package src.Easy.Problem110;

import java.util.*;
import src.Easy.common.TreeNode;
import src.Easy.common.TreeBuilder;
import src.Easy.common.TreeUtils;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if ( root == null ){ return true; }
        //int height_diff = Math.abs( maxDepth(root.left) - maxDepth(root.right) );
        //if ( height_diff > 1 ){ return false; }
        //return isBalanced(root.left) && isBalanced(root.right);
        
        return ( maxDepthDiff(root) != -1 );
    }

    public int maxDepthDiff(TreeNode root) {
        if ( root == null ){ return 0; }
        if ( ( root.left == null ) && ( root.right == null ) ){
            return 1;
        }

        int leftDepth = maxDepthDiff(root.left);
        if ( leftDepth == -1 ){ return -1;}
        int rightDepth = maxDepthDiff(root.right);
        if ( rightDepth == -1 ){ return -1;}

        int currDepthDiff = Math.abs(leftDepth - rightDepth);
        if ( currDepthDiff > 1 ){ return -1; }
        
        return 1 + Math.max(leftDepth, rightDepth);

    }
    
    public int maxDepth(TreeNode root) {
        if ( root == null ){ return 0; }
        if ( ( root.left == null ) && ( root.right == null ) ){
            return 1;
        }

        if ( root.left == null ){ return 1 + maxDepth(root.right); }
        if ( root.right == null ){ return 1 + maxDepth(root.left); }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public List<Integer> treeToList(TreeNode root, int numNodes){
        if ( root == null || numNodes == 0 ){ return null; }
        
        List<Integer> sol = new ArrayList<Integer>();
        LinkedList<TreeNode> toBeProcessed = new LinkedList<>();
        toBeProcessed.addFirst(root);

        TreeNode curr;

        for ( int treeIdx = 0; treeIdx < numNodes; ){
            curr = toBeProcessed.removeLast();
            if ( curr != null ){
                sol.add(curr.val);
                toBeProcessed.addFirst(curr.left);
                toBeProcessed.addFirst(curr.right);
                treeIdx = treeIdx + 1;
            } else { sol.add(null); }
        }

        return sol;
    }

    public void printList(List<Integer> input){

        if ( input == null ){
            System.out.print("[ ]");
            return;
        }

        System.out.print("[ ");
        for ( int printIdx = 0; printIdx < input.size(); printIdx++ ){
            System.out.print(input.get(printIdx));
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(3,9,20,null,null,15,7));
        sol.printList(testcase);
        TreeNode tcRoot = TreeBuilder.buildTree(testcase);
        System.out.println(sol.isBalanced(tcRoot));
        
        //tc2
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,2,3,3,null,null,4,4));
        // sol.printList(testcase);
        // TreeNode tcRoot = sol.buildTree(testcase);
        // System.out.println(sol.isBalanced(tcRoot));

    }
}