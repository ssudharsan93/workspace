#!/usr/bin/python

from typing import List
from pprint import pprint

def twoSum(nums: List[int], target:int ) -> List[int]:
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    
    pairs = dict()
    for i,n in enumerate(nums):
        if n not in pairs:
            pairs[(target-n)] = i
        else:
            return [ pairs[n], i]

def main():
    inputList = [-5, 6, 7, 8, -11, 2]
    target = 9

    pprint(inputList)
    pprint( twoSum(inputList, target) )


if __name__ == "__main__":
    main()
