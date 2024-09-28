package src.Easy.Problem94;

import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return recursiveSolution(root, new ArrayList<Integer>());
    }
    
    public List<Integer> recursiveSolution(TreeNode curr, List<Integer> result){
        if ( curr == null ){
            return result;
        }   

        if ( curr.left != null ){
            result = recursiveSolution(curr.left, result);
        }

        result.add(Integer.valueOf(curr.val));

        if ( curr.right != null ){
            result = recursiveSolution(curr.right, result);
        }
        
        return result;
    }

    public TreeNode buildTree(List<Integer> input){
        System.out.println(input.size());
        TreeNode root = new TreeNode(input.get(0).intValue());
        TreeNode curr = root;

        for ( int buildIdx = 1; buildIdx < input.size(); buildIdx++ ){


        }
        return null;
    }

    public static void main(String[] args){ 
        List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,null,2,3));
        Solution sol = new Solution();
        sol.buildTree(testcase);

    }
}