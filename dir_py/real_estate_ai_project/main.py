#!/usr/bin/env python3.12

import project_tools.api_requests as proj_api
import project_tools.utils as proj_utils

from dotenv import load_dotenv
import pathlib
import pprint
import numpy as np
import os
import argparse
import typing
import logging

load_dotenv()

CWD = pathlib.Path(__file__).parent.resolve()

if not os.path.exists("logging"):
    os.makedirs("logging")
logger = logging.getLogger(__name__)
logging.basicConfig(level=logging.INFO, format='%(asctime)s %(levelname)-8s %(message)s', datefmt='%a, %d %b %Y %H:%M:%S', filename='logging/main.log', filemode='w')
logging.basicConfig(level=logging.DEBUG, format='%(asctime)s %(levelname)-8s %(message)s', datefmt='%a, %d %b %Y %H:%M:%S', filename='logging/debug.log', filemode='w')

def write_output_file(
    output_dir_file_path : pathlib.Path, 
    address : str, 
    content: str, 
    file_type: str = "md"
) -> dict:
    if not os.path.exists(output_dir_file_path):
        os.makedirs(output_dir_file_path)
    address_str = address.replace(" ", "_").replace(",", "_")
    output_file_path = pathlib.Path(output_dir_file_path, f"{address_str}_property_info.{file_type}").resolve()
    with open(output_file_path, "w+") as output_file:
        output_file.write(content)
    return

# Read the LLM prompt to generate a property information html file 
def read_html_prompt(file_path : pathlib.Path) -> dict:
    prompt_file_path = pathlib.Path(file_path, "html_prompt.md").resolve()
    with open(prompt_file_path, "r") as f:
        prompt = f.read()
    return ( {"title" : prompt_file_path.name, "text" : prompt} )

# Read the LLM prompt to generate a property information markdown file 
def read_markdown_prompt(file_path : pathlib.Path) -> dict:
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

# Generate an Address String from a dictionary of address information.
def generate_address_str(address : dict) -> str:
    return f"{address['street_number']} {address['street_name']}, {address['city']}, {address['state']} {address['zip_code']}"

# Generate an output file for a given address that specifies the property information.
def gen_output_file(
    config_path : pathlib.Path, 
    output_path : pathlib.Path, 
    address : typing.Union[dict, str],
    file_type: str = "md"
) -> None:
    
    address_str = str()
    base_prompt = str()

    if isinstance(address, dict):
        address_str = generate_address_str(address)
    elif isinstance(address, str):
        address_str = address
    
    if file_type == "md":
        prompt_info = read_markdown_prompt(config_path)
        base_prompt = prompt_info["text"]

    elif file_type == "html":
        prompt_info = read_html_prompt(config_path)
        base_prompt = prompt_info["text"]
        
    qualified_prompt = base_prompt.replace("{ADDRESS}", f" {address_str} ")
    #pprint.pprint(qualified_prompt)
    response = proj_api.make_api_request(qualified_prompt)
    write_output_file(output_path, address_str, response, file_type)

# Prompt the user for an address if no address is provided through either a .yaml file or the --address option.
def prompt_user_for_address() -> str:
    input_str = "Enter an address (in the format: \"123 Main Street, New York, NY 10001\")\n" +\
        "include a street number, street name, city, state, and zip code.\n" +\
        "(Make sure to wrap your address in double quotes): "
    address = input(input_str).replace('"', "")
    return address

def main():
    argparser = argparse.ArgumentParser(
        prog="real_estate_ai_project",
        description="Provide a conf.yaml file in config or use the --address option to specify an address."
    )

    argparser.add_argument(
        "--address", 
        type=str, 
        help="The address to generate property info for." + 
        " Should include a street number, street name, city, state, and zip code. "
    )

    args = argparser.parse_args()
    config_path = pathlib.Path(CWD, "config")
    output_path = pathlib.Path(CWD, "output")

    address = str()

    if args.address:
        address = args.address
    elif os.path.exists(pathlib.Path(config_path, "conf.yaml")):
        _CONF = proj_utils.load_config_yaml(pathlib.Path(config_path, "conf.yaml"))
        address = generate_address_str(_CONF["address"])
    else: 
        address = prompt_user_for_address()

    if address:
        pprint.pprint(f"Generating property info (in a markdown file) for address: {address}")
        logging.info(f"Generating property info (in a markdown file) for address: {address}")
        gen_output_file(config_path, output_path, address)
        logging.info(f"Finished generating property info (in a markdown file).")
        pprint.pprint(f"Finished generating property info (in a markdown file).")
        logging.info(f"Generated property info (in an html file) for address: {address}")
        pprint.pprint(f"Generated property info (in an html file) for address: {address}")
        gen_output_file(config_path, output_path, address, "html")
        logging.info(f"Finished generating property info (in an html file).")
        pprint.pprint(f"Finished generating property info (in an html file).")



if __name__ == "__main__":
    main()