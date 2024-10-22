#!/usr/local/lib/python3.11
import sys
#from crew_test.crew import CrewTestCrew
from crew import VacationPlanningCrew
from dotenv import load_dotenv

load_dotenv()

# This main file is intended to be a way for your to run your
# crew locally, so refrain from adding necessary logic into this file.
# Replace with inputs you want to test with, it will automatically
# interpolate any tasks and agents information

def run():
    """
    Run the crew.
    """
    inputs = {
        'stops': '[Olympia - Washington, Boise - Idaho, Helena - Montana, Bismarck - North Dakota, Pierre - South Dakota, St. Paul - Minnesota]',
        'vehicle': 'motorcycle',
    }
    VacationPlanningCrew().crew().kickoff(inputs=inputs)


def train():
    """
    Train the crew for a given number of iterations.
    """
    inputs = {
        'stops': '[Olympia - Washington, Boise - Idaho, Helena - Montana, Bismarck - North Dakota, Pierre - South Dakota, St. Paul - Minnesota]',
        'vehicle': 'motorcycle',
    }
    try:
        VacationPlanningCrew().crew().train(n_iterations=int(sys.argv[1]), filename=sys.argv[2], inputs=inputs)

    except Exception as e:
        raise Exception(f"An error occurred while training the crew: {e}")

def replay():
    """
    Replay the crew execution from a specific task.
    """
    try:
        VacationPlanningCrew().crew().replay(task_id=sys.argv[1])

    except Exception as e:
        raise Exception(f"An error occurred while replaying the crew: {e}")

def test():
    """
    Test the crew execution and returns the results.
    """
    inputs = {
        'stops': '[Olympia - Washington, Boise - Idaho, Helena - Montana, Bismarck - North Dakota, Pierre - South Dakota, St. Paul - Minnesota]',
        'vehicle': 'motorcycle',
    }
    try:
        VacationPlanningCrew().crew().test(n_iterations=int(sys.argv[1]), openai_model_name=sys.argv[2], inputs=inputs)

    except Exception as e:
        raise Exception(f"An error occurred while replaying the crew: {e}")

run()