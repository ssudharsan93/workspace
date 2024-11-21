package src.common;

// Definition for a Node. For Problem 138 in Medium Problems

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node constructNodeLinkedList(String [][] testcaseStructure) {
        if ( testcaseStructure.length == 0 ){
            return null;
        }

        Node [] allNodes = new Node[testcaseStructure.length];

        Node prev = null; 
        for ( int nodeIdx = 0; nodeIdx < testcaseStructure.length; nodeIdx++ ){
            Node curr = new Node(Integer.parseInt(testcaseStructure[nodeIdx][0]));
            allNodes[nodeIdx] = curr;
            if ( prev != null ){
                prev.next = curr;
            }
            prev = curr;
        }

        for ( int nodeIdx = 0; nodeIdx < testcaseStructure.length; nodeIdx++ ){
            Node curr = allNodes[nodeIdx];
            String randomIdx = testcaseStructure[nodeIdx][1];
            if ( randomIdx != "null" ){ curr.random = allNodes[Integer.parseInt(randomIdx)]; }
            prev = curr;
        }

        return allNodes[0];
    }

    public static void printNodeLinkedList(Node head) {
        if ( head == null ){
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.println("\tval: " + curr.val);
            Node randomNode = curr.random;
            if ( randomNode != null ) { 
                System.out.println("\trandom val: " + randomNode.val);
            } else { 
                System.out.println("\trandom val: null");
            }

            curr = curr.next;
        }
    }
}
