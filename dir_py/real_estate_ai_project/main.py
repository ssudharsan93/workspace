#!/usr/bin/env python3.12

import project_tools.api_requests as proj_api
import project_tools.utils as proj_utils

from dotenv import load_dotenv
import pathlib
import pprint
import numpy as np
import os

load_dotenv()

CWD = pathlib.Path(__file__).parent.resolve()

def write_output_file(output_dir_file_path : pathlib.Path, address : dict, content: str) -> dict:
    if not os.path.exists(output_dir_file_path):
        os.makedirs(output_dir_file_path)
    street_name = address["street_name"].replace(" ", "_")
    address_str = f"{address['street_number']}_{street_name}_{address['city']}_{address['state']}_{address['zip_code']}"
    output_file_path = pathlib.Path(output_dir_file_path, f"{address_str}_property_info.md").resolve()
    try:
        with open(output_file_path, "r") as output_file:
            output_file.write(content)
        return
    except FileNotFoundError:
        print(f"Error: {output_file_path} not found.")
        exit(-1)
    
def read_prompt(file_path : pathlib.Path) -> dict:
    prompt_file_path = pathlib.Path(file_path, "prompt.md").resolve()
    with open(prompt_file_path, "r") as f:
        prompt = f.read()
    return ( {"title" : prompt_file_path.name, "text" : prompt} )

def generate_random_address() -> dict:
    return {
        "street_number" : np.random.randint(1, 9999).astype(str),
        "street_name" : "Main Street",
        "city" : "New York",
        "state" : "New York",
        "zip_code" : np.random.randint(10000, 99999).astype(str)
    }

def generate_address_str(address : dict) -> str:
    return f"{address['street_number']} {address['street_name']}, {address['city']}, {address['state']} {address['zip_code']}"

def main():    
    config_path = pathlib.Path(CWD, "config")
    prompt_info = read_prompt(config_path)
    _CONF = proj_utils.load_config_yaml(pathlib.Path(config_path, "conf.yaml"))
    main_address = _CONF["address"]
    base_prompt = prompt_info["text"]
    address_str = generate_address_str(main_address)
    qualified_prompt = base_prompt.replace("{ADDRESS}", f" {address_str} ")
    pprint.pprint(qualified_prompt)

    #response = proj_api.send_prompt(qualified_prompt)
    #write_output_file(config_path, _CONF, response)

if __name__ == "__main__":
    main()