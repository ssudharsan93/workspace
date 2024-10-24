#!/usr/bin/env python
import sys
from crew import LatestAiDevelopmentCrew
from tools.custom_tool import RedditTool, TwitterTool, YoutubeTool
import dotenv
import os

# This main file is intended to be a way for you to run your
# crew locally, so refrain from adding necessary logic into this file.
# Replace with inputs you want to test with, it will automatically
# interpolate any tasks and agents information

def run():
    """
    Run the crew.
    """
    inputs = {
        'topic': 'Artificial Intelligence, Machine Learning and Large Language Models',
        'num_items': '100'
    }
    LatestAiDevelopmentCrew().crew().kickoff(inputs=inputs)


def train():
    """
    Train the crew for a given number of iterations.
    """
    inputs = {
        "topic": 'Artificial Intelligence, Machine Learning and Large Language Models',
        'num_items': '100'
    }
    try:
        LatestAiDevelopmentCrew().crew().train(n_iterations=int(sys.argv[1]), filename=sys.argv[2], inputs=inputs)

    except Exception as e:
        raise Exception(f"An error occurred while training the crew: {e}")

def replay():
    """
    Replay the crew execution from a specific task.
    """
    try:
        LatestAiDevelopmentCrew().crew().replay(task_id=sys.argv[1])

    except Exception as e:
        raise Exception(f"An error occurred while replaying the crew: {e}")

def test():
    """
    Test the crew execution and returns the results.
    """
    inputs = {
        "topic": 'Artificial Intelligence, Machine Learning and Large Language Models',
        'num_items': '100'
    }
    try:
        LatestAiDevelopmentCrew().crew().test(n_iterations=int(sys.argv[1]), openai_model_name=sys.argv[2], inputs=inputs)

    except Exception as e:
        raise Exception(f"An error occurred while replaying the crew: {e}")
    
def main():
    dotenv.load_dotenv()
    reddit_topic = "NVMe SSDs"
    #RedditTool()._run("NVMe SSDs")
    TwitterTool()._run(reddit_topic)

    hashtag = "#richardfeynman #physics"  # Replace with your desired hashtag
    videos = YoutubeTool()._run(hashtag, max_results=5)

    if videos:
        print(f"Top videos for '{hashtag}':")
        for video in videos:
            print(f"Title: {video['title']}")
            print(f"Published At: {video['published_at']}")
            print(f"URL: {video['url']}\n")
    else:
        print("No videos found.")

main()
