#!/usr/bin/env python3.11

import api_requests
import pydantic
import json

class Location(pydantic.BaseModel):
   city: str
   state: str

def make_prompt_request(prompt_str):
    return api_requests.make_api_request(prompt_str)

def classify(prompt, labels):
    prompt_str = "Classify <<<" + prompt + ">>> with one of the " +\
    "following labels " +  ", ".join(labels) + "."
    return make_prompt_request(prompt_str)

def extract(prompt, target):
    print(target.model_json_schema())
    prompt_str = "Extract the entities from <<<" + prompt + ">>> in " +\
    "the following structure: ### " + json.dumps(target.model_dump()) + " ### " +\
    "and fill in the remaining fields with the most appropriate information." 
    #return make_prompt_request(prompt_str)

def generate(n, target, instructions):
    prompt_str = "Generate " + str(n) + " entities corresponding to <<<" + instructions +\
    ">>> in " +"the following structure: ### " + json.dumps(target.model_config) + " ### " +\
    "and fill in the remaining fields with the most appropriate information." 
    return make_prompt_request(prompt_str)

def main():
    #prompt = "Marvin is so easy to use!"
    #print("Classifying " + "<<<" + prompt + ">>>")
    #print(classify(prompt,labels=["positive", "negative"]))
    print(extract("I moved from NYC to CHI", target=Location))
    #print(
    #    generate(
    #        n=5, 
    #        target=Location, 
    #        instructions="cities in the United States named after presidents"
    #    )
    #)

if __name__ == "__main__":
    main()