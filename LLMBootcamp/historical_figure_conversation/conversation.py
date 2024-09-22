#!/usr/bin/env python3.11

import api_requests
import pydantic
import json

from headers import test_header_str, person_str

def make_prompt_request(prompt_str):
    return api_requests.make_api_request(prompt_str)

def converse(initial_prompt, orator1, orator2):
    prompt_str = test_header_str() + person_str(orator1, orator2, initial_prompt)
    response = make_prompt_request(prompt_str)
    print(orator1 + ": " +response)
    print("\n")

    for x in range(0, 10):
        if ( x % 2 == 0 ):
            prompt_str = test_header_str() + person_str(orator2, orator1, response)
            response = make_prompt_request(prompt_str)
            print(orator2 + ": " + response)
            print("\n")

        else:
            prompt_str = test_header_str() + person_str(orator1, orator2, response)
            response = make_prompt_request(prompt_str)
            print(orator1 + ": " +response)
            print("\n")



def main():
    converse(
        "How do we approach world problems and solve them?", 
        "Napoleon", "Nelson Mandela")



if __name__ == "__main__":
    main()