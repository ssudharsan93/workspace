#!/usr/bin/env python3.11

from pydantic import BaseModel
from openai import OpenAI
from typing import List
import os
import logging

def fetch_response(messages):
    client = OpenAI()

    completion = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=messages,
    )

    return completion.choices[0].message.content

def generate_prompt_dataset():
    with open('dataset_prompt.md') as file:
        output = fetch_response(
            [
                {
                    "role": "user",
                    "content": file.read()
                }
            ],
        )
        return output
    
def save_dataset(extension):
    num_files = len(os.listdir(dataset_dir))
    curr_file_path = os.path.join(dataset_dir, "prompt_dataset" + str((num_files + 1)) + extension)
    with open(curr_file_path, 'w+') as prompts_fd:
        prompts_fd.write(str(generate_prompt_dataset()))

def create_datasets():
    extension = ".csv"
    for x in range(10):
        save_dataset(extension)

def main():
    global dataset_dir
    dataset_dir = os.path.join(os.getcwd(), 'datasets')
    if ( not os.path.exists(dataset_dir) ):
        os.mkdir(dataset_dir)
    create_datasets()    

if __name__ == "__main__":
    main()
