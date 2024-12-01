#!/usr/bin/env python3.12

import project_tools.api_requests as proj_api
from dotenv import load_dotenv
import pathlib
import pprint

load_dotenv()

CWD = pathlib.Path(__file__).parent.resolve()

def read_prompt(file_path : pathlib.Path) -> dict:
    prompt_file_path = pathlib.Path(file_path, "prompt.md").resolve()
    with open(prompt_file_path, "r") as f:
        prompt = f.read()
    return ( {"title" : prompt_file_path.name, "text" : prompt} )

def main():    
    config_path = pathlib.Path(CWD, "config")
    prompt_info = read_prompt(config_path)
    pprint.pprint(prompt_info)

if __name__ == "__main__":
    main()