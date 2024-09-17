#!/usr/bin/python

from typing import List
from pprint import pprint
import math

class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next

     def printListNodes(self):
         another_node_poss = True
         while another_node_poss:
             print(str(self.val) + " -> ", end='')
             if not self.next:
                 print("NONE" + "\n")
                 another_node_poss = False
             self = self.next

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """

    if l1 is None and l2 is not None: return l2
    if l2 is None and l1 is not None: return l1
    if l1 is None and l2 is None: return None

    another_node_poss = True
    carry = 0
    final_result = ListNode()

    l1_curr_pos = l1
    l2_curr_pos = l2

    current_result_pos = final_result
    prev_result_pos = None

    while another_node_poss:
        if l1_curr_pos: l1_curr_val = l1_curr_pos.val
        else: l1_curr_val = 0

        if l2_curr_pos: l2_curr_val = l2_curr_pos.val
        else: l2_curr_val = 0

        curr_val = l1_curr_val + l2_curr_val + carry
        value_to_be_stored = curr_val % 10

        if math.floor(curr_val / 10) == 1: carry = 1
        else: carry = 0

        current_result_pos.val = value_to_be_stored
        if prev_result_pos: prev_result_pos.next = current_result_pos

        if l1_curr_pos: l1_curr_pos = l1_curr_pos.next
        if l2_curr_pos: l2_curr_pos = l2_curr_pos.next

        if not l1_curr_pos and not l2_curr_pos and carry == 0:
            another_node_poss = False
        elif not l1_curr_pos and not l2_curr_pos and carry == 1:
            current_result_pos.next = ListNode(1)
            another_node_poss = False
        else:
            prev_result_pos = current_result_pos
            current_result_pos = ListNode()

    return final_result

def turnListIntoLinkedList(desired_list: List) -> List:
    size_of_list = len(desired_list)

    res = ListNode(desired_list[0])

    for x in range(0, size_of_list):
        curr = ListNode(desired_list[x])
        if x == 0: continue
        elif x == 1: prev = res
        prev.next = curr
        prev = curr

    return res

def main():
    l1 = turnListIntoLinkedList([9, 9, 9])
    l2 = turnListIntoLinkedList([9, 9, 9, 9, 9])

    l1.printListNodes()
    l2.printListNodes()

    res = addTwoNumbers(l1, l2)
    res.printListNodes()
    #expected_result = [1000998] -> 8990001

    l3 = turnListIntoLinkedList([2,4,3])
    l4 = turnListIntoLinkedList([5,6,4])

    l3.printListNodes()
    l4.printListNodes()

    res = addTwoNumbers(l3, l4)
    res.printListNodes()
    #expected_result = 807 -> 7-0-9


if __name__ == "__main__":
    main()
