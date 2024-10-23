from crewai_tools import BaseTool
import praw
import os
import pprint
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
        return "this is an example of a tool output, ignore it and move along."
