#### Installation ####
1. Make sure Python 3.12 is installed in your machine.
2. Clone this repository.
3. Navigate to the real_estate_ai_project folder.
4. Run pip install -r requirements.txt

#### Description ####
This script takes in an address argument and makes the necessary substitutions
in two prompts that can be viewed in the config/ directory. There is a html prompt ( html_prompt.md )
and a markdown prompt ( prompt.md ). Both are prompts to an LLM using the COSTAR framework
that ask the LLM to generate real estate information for a particular property specified by an address.

#### Setup ####
You must create a .env file and place it in the root directory of this folder.
The .env file must contain the following:
OPENAI_API_KEY="YOUR_OPEN_AI_API_KEY"

You will have to replace YOUR_OPEN_AI_API_KEY with your own OpenAI api key.
This API key will be used to submit requests to the Open AI API.

#### Running ####
To run this script simply run ```python main.py```
You can provide an address to this script via the command line with the --address argument.
You can also provide the address in a file that must be named `conf.yaml` and placed in 
the config/ directory in this project folder.

The conf.yaml file must contain the following structure ( An example address is provided for your convenience ):
```
address:
    street_number:
        123 
    street_name:
        Main Street
    city:
        New York City
    state:
        New York
    zip_code:
        10001
```
You would substitute the values in each field based on your discretion.

If you don't provide a `conf.yaml` file in the correct location or the --address argument
you will be prompted for an address. 

Once an address is provided the script will generate two report files in the output/ directory 
( the directory will be created if it does not exist. ). A markdown file and an html file. 
These contain two different formats of reports.