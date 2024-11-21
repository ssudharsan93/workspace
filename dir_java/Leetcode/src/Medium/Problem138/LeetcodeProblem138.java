package src.Medium.Problem138;

import java.util.*;
import java.math.BigInteger;
import src.common.Node;

class Solution {
    public Node copyRandomList(Node head) {
        if ( head == null ){
            return null;
        }
        
        Node prev = head;                  
        Node next = head.next;
        // First loop creates A -> A' -> B -> B' structures       
        while ( prev != null ){
            Node copied = new Node(prev.val);
            prev.next = copied; // A -> A'
            copied.next = next; // A' -> B
            prev = next; // prev = B
            if ( prev != null ){
                next = prev.next; // next = C
            }
        }

        prev = head;
        Node curr = head.next;
        Node copiedHead = curr;

        // Second loop makes sure A', B' i.e. copied nodes point to right random node.
        // As well as correct next node.
        while ( prev != null ){ 
            if ( prev.random != null ){
                curr.random = prev.random.next;
            }
            
            prev = curr.next; // prev = B
            if ( prev != null ){ 
                curr = prev.next; // curr = B'
            }
        }

        prev = head;
        curr = prev.next;

        // Third loop separates copied and original nodes to make the following structures:
        // A -> B -> C -> D
        // A' -> B' -> C' -> D'
        while ( prev != null ){
            prev.next = curr.next; // A -> B
            prev = curr.next; // prev = B
            if ( prev != null ){ 
                curr.next = curr.next.next; // A' -> B'
                curr = prev.next; // curr = B'
            }
        }

        return copiedHead;
    }


    public static void main(String[] args){ 
        Solution sol = new Solution();

        String [][] tcStructure = new String[][]{{"7","null"},{"13","0"},{"11","4"},{"10","2"},{"1","0"}};
        Node tcHead = Node.constructNodeLinkedList(tcStructure);
        System.out.println("Original:");
        Node.printNodeLinkedList(tcHead);
        Node result = sol.copyRandomList(tcHead);
        System.out.println("Copied:");
        Node.printNodeLinkedList(result);

    }
}