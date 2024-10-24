from crewai_tools import BaseTool
import praw
import os
import pprint
import tweepy
import requests
import json


class RedditTool(BaseTool):
    name: str = "Returns reddit threads for a given topic."
    description: str = (
        "Returns reddit text for a given topic that is requested by a user to be investigated."
    )

    def _run(self, reddit_topic: str) -> str:
        # Implementation goes here
        
        reddit = praw.Reddit(
            client_id=os.environ['REDDIT_CLIENT_ID'],
            client_secret=os.environ['REDDIT_CLIENT_SECRET'],
            user_agent=os.environ['REDDIT_USER_AGENT']
        )
        
        df = reddit.subreddit("all").search(query=reddit_topic, limit=1000)

        for subreddit in df:
            pprint.pprint(subreddit.title)
            pprint.pprint(subreddit.url)
            pprint.pprint(subreddit.selftext)
            pprint.pprint(subreddit.author)
            pprint.pprint(subreddit.created_utc)
    

class TwitterTool(BaseTool):
    name: str = "Returns tweets for a given topic."
    description: str = (
        "Returns twitter text for a given topic that is requested by a user to be investigated."
    )

    def _run(self, twitter_topic: str) -> str:
        # Implementation goes here

        print(os.environ['TWITTER_BEARER_TOKEN'])

        client = tweepy.Client(bearer_token=os.environ['TWITTER_BEARER_TOKEN'])

        response = client.search_recent_tweets(query=twitter_topic, max_results=10)
        
        if response.data:
            for tweet in response.data:
                print(f"Tweet: {tweet.text}, Created at: {tweet.created_at}")
        else:
            print("No tweets found.")


APIKEY = 'YOURAPIKEY'
BASEURL = 'https://www.googleapis.com/youtube/v3/search'

class YoutubeTool(BaseTool):
    name: str = "Returns tweets for a given topic."
    description: str = (
        "Returns twitter text for a given topic that is requested by a user to be investigated."
    )

    def _run(self, query, max_results=10):
        """
        Queries YouTube API for videos with specific hashtags and sorts them by relevance and date.

            Parameters:
            
        query: Hashtag or search term to query (e.g., "#example").
        max_results: Maximum number of videos to return (default is 10).

        Returns:
        List of videos with title, video ID, published date, and URL.
        """

        API_KEY = 'YOURAPIKEY'
        BASE_URL = 'https://www.googleapis.com/youtube/v3/search'
        # Sorted by date (most recent first)
        params = {'part': 'snippet','q': query,'type': 'video','order': 'date', 'maxResults': max_results,'key': API_KEY}

        response = requests.get(BASE_URL, params=params)

        if response.status_code != 200:
            print(f"Error: {response.status_code} - {response.text}")
            return []

        videos = response.json().get('items', [])

        result = []
        for video in videos:
            video_data = {
                'title': video['snippet']['title'],
                'video_id': video['id']['videoId'],
                'published_at': video['snippet']['publishedAt'],
                'url': f"https://www.youtube.com/watch?v={video['id']['videoId']}"
            }
            result.append(video_data)

        return result
