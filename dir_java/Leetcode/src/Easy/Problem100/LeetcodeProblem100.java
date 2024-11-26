package src.Easy.Problem100;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;
import src.common.ListUtils;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null || q == null ){
            if ( p == null && q == null ){ return true; }
            else { return false;}
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        List<Integer> pInput = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> qInput = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ListUtils.printIntegerList(pInput);
        ListUtils.printIntegerList(qInput);
        TreeNode p = TreeBuilder.buildTree(pInput);
        TreeNode q = TreeBuilder.buildTree(qInput);
        System.out.println(sol.isSameTree(p, q));

        //tc2
        // List<Integer> pInput = new ArrayList<Integer>(Arrays.asList(1, 2));
        // List<Integer> qInput = new ArrayList<Integer>(Arrays.asList(1, null, 2));
        // ListUtils.printIntegerList(pInput);
        // ListUtils.printIntegerList(qInput);
        // TreeNode p = sol.buildTree(pInput);
        // TreeNode q = sol.buildTree(qInput);
        // System.out.println(sol.isSameTree(p, q));


        //tc3
        // List<Integer> pInput = new ArrayList<Integer>(Arrays.asList(1, 2, 1));
        // List<Integer> qInput = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        // ListUtils.printIntegerList(pInput);
        // ListUtils.printIntegerList(qInput);
        // TreeNode p = sol.buildTree(pInput);
        // TreeNode q = sol.buildTree(qInput);
        // System.out.println(sol.isSameTree(p, q));

        
    }
}