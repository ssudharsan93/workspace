import streamlit as st
import pandas as pd
import numpy as np
from io import StringIO
import PyPDF2
import sys
import os

from openai import OpenAI
from pathlib import Path

client = OpenAI()

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
sys.stdout.reconfigure(encoding='utf-8')

import llm_bootcamp_tools.api_requests as llmbcapi

def submit_prompt(request, text):
    prompt = f'''
    ### Objective ###
    #    The objective is to carry out the request between <Request></Request> tags.
    #    Perform the request on the data between <Data></Data> tags. All of this 
    #    information will be provided below.

    <Request>{request}</Request>
    <Data>{text}</Data> 
    '''

    return llmbcapi.make_api_request(prompt)

def read_pdf(filename):
    with open(filename, 'rb') as file:
        reader = PyPDF2.PdfReader(file)
        num_pages = len(reader.pages)

        text = ""
        for page_num in range(num_pages):
            page = reader.pages[page_num]
            text += page.extract_text()
        
        text = text.replace("<pad>", "")
        text = text.replace("<EOS>", "")

        end_idx = text.lower().find("references")

        return text[:end_idx]
    
st.write("Upload Text or PDF file to be processed")

uploaded_file = st.file_uploader("Choose a file")
if uploaded_file is not None:
    # To read file as bytes:
    #bytes_data = uploaded_file.getvalue()
    #st.write(bytes_data)

    #st.write(uploaded_file)
    extension = uploaded_file.name.split(".")[1]

    text = ""
    if ( extension == "pdf" ):
        text = read_pdf(uploaded_file.name)

    st.write("Text contains " + str(len(text.split("\n"))) + " lines.")
    if st.checkbox('Show Text'):
        st.write(text)

    # To convert to a string based IO:
    #stringio = StringIO(uploaded_file.getvalue().decode("utf-8"))
    #st.write(stringio)

    # To read file as string:
    #string_data = stringio.read()
    #st.write(string_data)

    # Can be used wherever a "file-like" object is accepted:
    #dataframe = pd.read_csv(uploaded_file)
    #st.write(dataframe)

    if st.checkbox('Interact with Chatbot'):
        st.write('''
            Ask the Open AI Chatbot what you would like to do with the text.
        ''')
        request = st.chat_input("What would you like to do with your chosen body of text?")
        if request:
            msg = st.chat_message("user")
            msg.write(request)
            response = submit_prompt(request, text)
            if response:
                msg = st.chat_message("ai")
                msg.write(response)

    if st.checkbox('Generate Podcast Conversation'):
        request = '''
            Generate a podcast conversation based on this body 
            of text as a conversation between two people.
            Return the text based-transcript of the podcast where
            each exchange in the transcript is indexed by the name
            of the person speaking. Give both participants in the 
            conversation English names.
        '''

        if ( not os.path.exists("transcript.mp3") ):
            transcript = submit_prompt(request, text)

            if st.checkbox('Show Transcript'):
                st.write(transcript)        

            speech_file_path = Path(__file__).parent / "transcript.mp3"
            with client.audio.speech.with_streaming_response.create(
                model="tts-1",
                voice="alloy",
                input=transcript,
            ) as response:
                response.stream_to_file("transcript.mp3")

        st.audio("transcript.mp3", format="audio/mpeg", loop=True)



