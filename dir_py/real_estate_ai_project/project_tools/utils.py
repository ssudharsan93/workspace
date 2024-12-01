import yaml
import os
from collections import defaultdict
import pathlib

#wrapper example
def conf_location(func):
    def wrapper(*args, **kwargs):
        _CWD = os.getcwd()
        os.chdir(os.path.join(os.getcwd(), 'common'))
        result = func(*args, **kwargs)
        os.chdir(_CWD)
        return result
    return wrapper

def load_config_yaml(filepath : pathlib.Path) -> dict:
    try:
        with open(filepath, 'r') as conf_fd:
            _CONF = yaml.load(conf_fd, Loader=yaml.SafeLoader)
        return _CONF
    except FileNotFoundError:
        print(f"Error: {filepath} not found.")
        exit(-1)

def merge_dicts(*dict_args):
    merged = defaultdict(set)  # uses set to avoid duplicates
    for d in dict_args:
        merged.update(d)
    return dict(merged)