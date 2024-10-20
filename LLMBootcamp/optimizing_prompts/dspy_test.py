#! /usr/local/bin/python3.11
import dspy
from dspy.datasets.gsm8k import GSM8K, gsm8k_metric

from dspy.teleprompt import BootstrapFewShot
from dspy.evaluate import Evaluate

from pprint import pprint
import os

def write_output(fname, content):
    file = os.path.join(os.getcwd(), fname)
    with open(file, "w+") as fd:
        fd.write(content)

class CoT(dspy.Module):
    def __init__(self):
        super().__init__()
        self.prog = dspy.ChainOfThought("question -> answer")
    
    def forward(self, question):
        return self.prog(question=question)
    
class ReActModel(dspy.Module):
    def __init__(self):
        super().__init__()
        self.prog = dspy.ReAct("question -> answer")

    def forward(self, question):
        return self.prog(question=question)

def main():
    turbo=dspy.OpenAI(model='gpt-4o', max_tokens=250)
    dspy.settings.configure(lm=turbo)

    gsm8k = GSM8K()
    gsm8k_trainset, gsm8k_devset = gsm8k.train[:10], gsm8k.dev[:10]

    # Set up the optimizer: we want to "bootstrap" (i.e., self-generate) 4-shot examples of our CoT program.
    config = dict(max_bootstrapped_demos=4, max_labeled_demos=4)

    # Optimize! Use the `gsm8k_metric` here. In general, the metric is going to tell the optimizer how well it's doing.
    teleprompter = BootstrapFewShot(metric=gsm8k_metric, **config)
    optimized_cot = teleprompter.compile(CoT(), trainset=gsm8k_trainset)

    # Set up the evaluator, which can be used multiple times.
    evaluate = Evaluate(devset=gsm8k_devset, metric=gsm8k_metric, num_threads=4, display_progress=True, display_table=0)

    # Evaluate our `optimized_cot` program.
    evaluate(optimized_cot)

    turbo.inspect_history(n=3)

    write_output(
        "milky_way_prompt.txt",
        str(optimized_cot(question='What are the nearest galaxies to our Milky Way Galaxy?'))
    )

def test():
    turbo=dspy.OpenAI(model='gpt-4o', max_tokens=1024)
    dspy.settings.configure(lm=turbo)

    question = "What is the integral of a sinusoid?"
    choices = "another sinusoid, a hyperbolic function, or an exponential function"
    mcq_chooser = dspy.Predict("question, choices -> reasoning, selection")
    question_answerer = dspy.ChainOfThought("question, choices -> reasoning, selection")
    prediction_with_chain_of_thought = question_answerer(question=question, choices=choices)
    prediction = mcq_chooser(question=question, choices=choices)

    pprint(prediction)
    pprint(prediction_with_chain_of_thought)

    #write_output(
    #    'integral_prompt.txt',
    #    str(prediction)
    #)

    #write_output(
    #    'integral_prompt_with_CoT.txt',
    #    str(prediction_with_chain_of_thought)
    #)

    #gsm8k = GSM8K()
    #gsm8k_trainset, gsm8k_devset = gsm8k.train[:10], gsm8k.dev[:10]

    # Set up the optimizer: we want to "bootstrap" (i.e., self-generate) 4-shot examples of our CoT program.
    #config = dict(max_bootstrapped_demos=5, max_labeled_demos=5)

    # Optimize! Use the `gsm8k_metric` here. In general, the metric is going to tell the optimizer how well it's doing.
    #teleprompter = BootstrapFewShot(metric=gsm8k_metric, **config)
    #optimized_rm = teleprompter.compile(ReActModel(), trainset=gsm8k_trainset)

    # Set up the evaluator, which can be used multiple times.
    #evaluate = Evaluate(devset=gsm8k_devset, metric=gsm8k_metric, num_threads=4, display_progress=True, display_table=0)

    # Evaluate our `optimized_cot` program.
    #evaluate(optimized_rm)

    #turbo.inspect_history(n=3)


if __name__ == "__main__":
    main()
    #test()