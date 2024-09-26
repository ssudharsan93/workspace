package src.Problem20;


// Definition for singly-linked list.
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result, prev, curr;

        if ( list1 == null ){
            return list2;
        }

        if ( list2 == null ){
            return list1;
        }

        if ( list1.val <= list2.val ){
            curr = new ListNode(list1.val);
            result = curr;
            prev = curr;
            list1 = list1.next;
        } else { 
            curr = new ListNode(list2.val);
            result = curr;
            prev = curr;
            list2 = list2.next;
        }

        while ( list1 != null || list2 != null ){
            if ( list1 == null ){
                curr = new ListNode(list2.val);
                prev.next = curr;
                prev = curr;
                list2 = list2.next;
            }
            else if ( list2 == null ){
                curr = new ListNode(list1.val);
                prev.next = curr;
                prev = curr;
                list1 = list1.next;
            }
            else {
                if ( list1.val <= list2.val ){
                    curr = new ListNode(list1.val);
                    prev.next = curr;
                    prev = curr;
                    list1 = list1.next;
                } else { 
                    curr = new ListNode(list2.val);
                    prev.next = curr;
                    prev = curr;
                    list2 = list2.next;
                }
            }
        }

        return result;
    }
}