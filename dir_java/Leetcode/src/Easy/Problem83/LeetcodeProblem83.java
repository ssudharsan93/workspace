package src.Easy.Problem83;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev, curr;

        if ( head == null ){
            return null;
        }

        prev = head;
        curr = prev.next;

        while ( curr != null ){
            if ( prev.val == curr.val ){
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = prev.next;
            }
        }

        return head;
    }

    public ListNode createLinkedList(int[] testcaseList ){
        
        if ( testcaseList.length == 0 ){
            return null;
        }

        ListNode head = new ListNode(testcaseList[0]);
        ListNode prev = head;
        ListNode curr;

        for ( int tcIdx = 1; tcIdx < testcaseList.length; tcIdx++ ){
            curr = new ListNode(testcaseList[tcIdx]);
            prev.next = curr;
            prev = curr;
        }

        return head;
    }

    public void printLinkedList( ListNode head ){

        if ( head == null ){
            System.out.print("[ ]");
            return;
        }

        ListNode curr = head;
        System.out.print("[ ");
        while( curr != null ){
            System.out.print(curr.val);
            System.out.print(" ");
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        //int[] testcase = new int[]{1, 1, 2};
        int[] testcase = new int[]{};
        ListNode testcaseHead = sol.createLinkedList(testcase);
        //sol.printLinkedList(testcaseHead);
        ListNode uniqueList = sol.deleteDuplicates(testcaseHead);
        sol.printLinkedList(uniqueList);
    }

}