#!/usr/bin/env python3.11

from openai import OpenAI

def make_api_request(prompt):
    client = OpenAI()

    completion = client.chat.completions.create(
        model="gpt-4",
        messages=[
            {
                "role": "user",
                "content": prompt,
                "max_tokens":8192
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

if __name__ == "__main__":
    main()