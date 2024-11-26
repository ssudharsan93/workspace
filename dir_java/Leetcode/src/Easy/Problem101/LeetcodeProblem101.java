package src.Easy.Problem101;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;
import src.common.ListUtils;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if ( ( root.left == null ) && ( root.right == null ) ){ return true; }
        if ( ( root.left == null ) || ( root.right == null ) ){ return false; }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if ( left == null && right == null ){ return true; }
        if ( left == null || right == null ){ return false; }
        return ( left.val == right.val ) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
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
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,2,3,4,4,3));
        //ListUtils.printIntegerList(testcase);
        // TreeNode tcRoot = TreeBuilder.buildTree(testcase);
        // System.out.println(sol.isSymmetric(tcRoot));
        
        //tc2
        List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,2,null,3,null,3));
        ListUtils.printIntegerList(testcase);
        TreeNode tcRoot = TreeBuilder.buildTree(testcase);
        System.out.println(sol.isSymmetric(tcRoot));

        //tc3
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,2,null,3,3));
        //ListUtils.printIntegerList(testcase);
        // TreeNode tcRoot = TreeBuilder.buildTree(testcase);
        // System.out.println(sol.isSymmetric(tcRoot));


    }
}