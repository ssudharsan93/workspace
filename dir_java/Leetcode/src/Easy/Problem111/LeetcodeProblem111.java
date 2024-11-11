package src.Easy.Problem111;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;

class Solution {
    public int minDepth(TreeNode root) {
        if ( root == null ){ return 0; }
        if ( ( root.left == null ) && ( root.right == null ) ){
            return 1;
        }

        if ( root.left == null ){ return 1 + minDepth(root.right); }
        if ( root.right == null ){ return 1 + minDepth(root.left); }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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
        TreeUtils.printTree(tcRoot);
        System.out.println(sol.minDepth(tcRoot));

        //tc2
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(2,null,3,null,4,null,5,null,6));
        // sol.printList(testcase);
        // TreeNode tcRoot = TreeBuilder.buildTree(testcase);
        // TreeUtils.printTree(tcRoot);
        // System.out.println(sol.minDepth(tcRoot));
        
        //tc3
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,2,3,3,null,null,4,4));
        // sol.printList(testcase);
        // TreeNode tcRoot = sol.buildTree(testcase);
        // System.out.println(sol.minDepth(tcRoot));
        // System.out.println(sol.altMinDepth(tcRoot));


    }
}