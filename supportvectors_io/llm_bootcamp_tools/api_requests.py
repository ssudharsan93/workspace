#!/usr/bin/env python3.11

from openai import OpenAI
import marvin

def make_api_request(prompt):
    client = OpenAI()

    completion = client.chat.completions.create(
        model="gpt-4",
        messages=[
            {
                "role": "user",
                "content": prompt
            }
        ]
    )

    return completion.choices[0].message.content


def main():
    client = OpenAI()

    completion = client.chat.completions.create(
        model="gpt-4",
        messages=[
            {"role": "system", "content": "You are a helpful assistant."},
            {
                "role": "user",
                "content": "Write a haiku about recursion in programming."
            }
        ]
    )

    print(completion.choices[0].message.content)

    print(marvin.classify(
    "Marvin is so easy to use!",
    labels=["positive", "negative"],
    ))


if __name__ == "__main__":
    main()