package src.Easy.Problem141;

import java.util.*;
import java.math.BigInteger;
import src.common.*;

class Solution {
    public boolean hasCycle(ListNode head) {
        if ( head == null ){
            return false;
        }

        ListNode first = head;
        ListNode second = head.next;

        if ( second == null ){
            return false;
        }

        while ( ( first != null ) || ( second != null ) ) {
            if ( first == second ){ 
                return true;
            }

            first = first.next;
            if ( second.next == null ){
                break;
            }

            if ( second.next.next == null ){ 
                break;
            }
            
            second = second.next.next;
        }

        return false;
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1 
        int [] tc = new int[]{3,2,0,-4};
        int pos = 1;
        ListNode tc1Head = LinkedListUtils.buildLinkedList(tc, pos);
        LinkedListUtils.printLinkedList(tc1Head, tc.length);
        System.out.println(sol.hasCycle(tc1Head));

        //tc2 
        int [] tc2 = new int[]{1, 2};
        int pos2 = 0;
        ListNode tc2Head = LinkedListUtils.buildLinkedList(tc2, pos2);
        LinkedListUtils.printLinkedList(tc2Head, tc2.length);
        System.out.println(sol.hasCycle(tc2Head));

        //tc3 
        int [] tc3 = new int[]{1};
        int pos3 = -1;
        ListNode tc3Head = LinkedListUtils.buildLinkedList(tc3, pos3);
        LinkedListUtils.printLinkedList(tc3Head, tc3.length);
        System.out.println(sol.hasCycle(tc3Head));

    }
}