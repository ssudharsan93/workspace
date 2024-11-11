package src.Easy.Problem112;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;
import src.common.ListUtils;

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if ( root == null ){
            return false;
        }

        int newTargetSum = targetSum - root.val;
        
        if ( ( root.left == null ) && ( root.right == null ) ) {
            if ( newTargetSum == 0 ) { 
                return true;
            }
            return false;
        } 

        if ( root.left == null ) { 
            return hasPathSum(root.right, newTargetSum);
        }

        if ( root.right == null ) { 
            return hasPathSum(root.left, newTargetSum);
        }

        return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum);
    }
    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        int targetSum = 22;
        List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1));
        ListUtils.printList(testcase);
        TreeNode tcRoot = TreeBuilder.buildTree(testcase);
        TreeUtils.printTree(tcRoot);
        System.out.println(sol.hasPathSum(tcRoot, targetSum));

        //tc2
        // int targetSum = -5;
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(-2,null,-3));
        // sol.printList(testcase);
        // TreeNode tcRoot = TreeBuilder.buildTree(testcase);
        // TreeUtils.printTree(tcRoot);
        // System.out.println(sol.hasPathSum(tcRoot, targetSum));
        
        //tc3
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,2,3,3,null,null,4,4));
        // sol.printList(testcase);
        // TreeNode tcRoot = sol.buildTree(testcase);
        // System.out.println(sol.minDepth(tcRoot));
        // System.out.println(sol.altMinDepth(tcRoot));


    }
}