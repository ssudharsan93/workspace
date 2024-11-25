#!/usr/bin/env python3.12
import pathlib
import sqlite3
import pprint
import os
import numpy as np
import uuid # library generates random uuids for file names, databases etc.
import re
import logging

cwd = pathlib.Path(__file__).parent.resolve()
if not os.path.exists("logging"):
    os.makedirs("logging")
logger = logging.getLogger(__name__)
logging.basicConfig(level=logging.INFO, format='%(asctime)s %(levelname)-8s %(message)s', datefmt='%a, %d %b %Y %H:%M:%S', filename='logging/database.log', filemode='w')

def table_deletion_query() -> str:
    return """
            DROP TABLE IF EXISTS TRANSCRIPT;
        """
def table_creation_query() -> str:
    return """
            CREATE TABLE IF NOT EXISTS TRANSCRIPT (
                ID VARCHAR(255) NOT NULL PRIMARY KEY,
                DOC_ID VARCHAR(255) NOT NULL UNIQUE,
                TITLE VARCHAR(255) NOT NULL,
                TEXT LONGTEXT NOT NULL
            );
        """

def table_insertion_query(
        id : str, 
        doc_id : str,
        title : str, 
        text : str
) -> str:
    return f"""
            INSERT INTO TRANSCRIPT (ID, DOC_ID, TITLE, TEXT) VALUES ("{id}", "{doc_id}", "{title}", "{text}");
        """

def all_selection_query() -> str:
    return """
            SELECT ID, DOC_ID, TITLE FROM TRANSCRIPT;
        """

def id_existence_query(
        id : int
) -> str:
    return f"""
            SELECT ID FROM TRANSCRIPT WHERE ID = {str(id)};
        """

def test_table_insertion_query() -> str:
    return """
            INSERT INTO TRANSCRIPT (ID, DOC_ID, TITLE, TEXT) VALUES ("1", "DOCUMENT_ID", "Sample Title", "Hello World!");
        """

def insert_transcript(db_cursor, id : str, doc_id: str, title : str, text : str):
    logger.info(f"Inserting transcript: id={id}, doc_id={doc_id}, title={title}")
    db_cursor.execute(table_insertion_query(id, doc_id, title, text))

def read_transcript(file_path : pathlib.Path) -> dict:
    with open(file_path, "r") as f:
        transcript = f.read()
    return ( {"title" : file_path.name, "text" : transcript} ) #transcript

def get_document_id(file_name : str) -> str:
    pattern = r"\[(.*?)\]"
    search_results = re.findall(pattern, file_name)
    if search_results:
        if ( len(search_results) > 1 ):
            return f"{search_results[1]}"
        else:
            return f"{search_results[0]}" 
    
    return ""

def id_exists(db_cursor, id : int) -> bool:
    resp = db_cursor.execute(id_existence_query(id))
    return len(resp.fetchall()) > 0
    
def insert_transcripts(
        db_connection: sqlite3.Connection,
        db_cursor: sqlite3.Cursor, 
        transcripts_path : pathlib.Path
    ) -> None:
    num_documents = len(os.listdir(transcripts_path))

    for transcript_path in pathlib.Path(transcripts_path).iterdir():
        transcript = read_transcript(transcript_path)
        doc_id = get_document_id(transcript_path.name)
                
        insert_transcript(
           db_cursor,
           str(uuid.uuid4()),
           doc_id, 
           transcript["title"], 
           transcript["text"]
        )

    db_connection.commit()

def create_table(db_cursor):
    db_cursor.execute(table_creation_query())

def select_all(db_cursor):
    resp = db_cursor.execute(all_selection_query())
    return resp
def drop_table(db_cursor):
    db_cursor.execute(table_deletion_query())

def test_db_connection(
        db_path : pathlib.Path
) -> bool:
    try:
        db_connection = sqlite3.connect(db_path)
        db_cursor = db_connection.cursor()
        create_table(db_cursor)
        db_cursor.execute(test_table_insertion_query()) #test_table_insertion_query()
        resp = db_cursor.execute(all_selection_query())
        pprint.pprint(resp.fetchall())
        drop_table(db_cursor)

    except ( sqlite3.Error, Exception ) as e:
        pprint.pprint(e)
        #print("Error connecting to database:", e)
        return False

    finally:
        # Close the connection if it was opened
        if db_connection:
            db_connection.close()
    
    return True

def main():
    db_path = pathlib.PurePath(cwd, "database", "support_vectors_io_capstone_instructor.db")
    transcripts_path = pathlib.PurePath(cwd,"llm_bootcamp_lecture_transcripts", "only_transcript")

    try: 
        db_connection = sqlite3.connect(db_path)
        db_cursor = db_connection.cursor()

        drop_table(db_cursor)
        create_table(db_cursor)
        insert_transcripts(db_connection,db_cursor, transcripts_path)

    except ( sqlite3.Error, Exception ) as e:
        pprint.pprint(e)

    finally:
        # Close the connection if it was opened
        if db_connection:
            db_connection.close()


if __name__ == "__main__":
    main()