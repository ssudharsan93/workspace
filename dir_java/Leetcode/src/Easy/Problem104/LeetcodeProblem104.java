package src.Easy.Problem104;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;

class Solution {
    public int maxDepth(TreeNode root) {
        if ( root == null ){
            return 0;
        }

        if ( ( root.left == null ) && ( root.right == null ) ){
            return 1;
        }

        if ( root.left == null ){ return 1 + maxDepth(root.right); }
        if ( root.right == null ){ return 1 + maxDepth(root.left); }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
        System.out.println(sol.maxDepth(tcRoot));
        
        //tc2
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,null,2));
        // sol.printList(testcase);
        // TreeNode tcRoot = sol.buildTree(testcase);
        // System.out.println(sol.maxDepth(tcRoot));

        //tc2
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2));
        // sol.printList(testcase);
        // TreeNode tcRoot = sol.buildTree(testcase);
        // System.out.println(sol.maxDepth(tcRoot));


    }
}