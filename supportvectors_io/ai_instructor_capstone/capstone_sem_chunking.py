#!/usr/bin/env python3.12
import pathlib
import sqlite3
import pprint
import os
import numpy as np
import uuid # library generates random uuids for file names, databases etc.
import re
import logging
import semchunk

cwd = pathlib.Path(__file__).parent.resolve()
if not os.path.exists("logging"):
    os.makedirs("logging")
logger = logging.getLogger(__name__)
logging.basicConfig(level=logging.INFO, format='%(asctime)s %(levelname)-8s %(message)s', datefmt='%a, %d %b %Y %H:%M:%S', filename='logging/semchunking.log', filemode='w')

def all_selection_query() -> str:
    return """
            SELECT * FROM TRANSCRIPT;
        """

def select_all(db_cursor):
    resp = db_cursor.execute(all_selection_query())
    return resp

def main():
    db_path = pathlib.PurePath(cwd, "database", "support_vectors_io_capstone_instructor.db")
    
    try: 
        db_connection = sqlite3.connect(db_path)
        db_cursor = db_connection.cursor()

        resp = select_all(db_cursor)

        pprint.pprint(resp.fetchall())
    
    except ( sqlite3.Error, Exception ) as e:
        pprint.pprint(e)

    finally:
        # Close the connection if it was opened
        if db_connection:
            db_connection.close()    

if __name__ == "__main__":
    main()