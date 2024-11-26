package src.Easy.Problem108;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;
import src.common.ListUtils;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int endIdx = nums.length - 1;
        int startIdx = 0;

        return getSubBST(nums, startIdx, endIdx);
    }

    public TreeNode getSubBST(int[] nums, int startIdx, int endIdx){
        int midpoint = (int) Math.floor(( endIdx + startIdx ) / 2.0);

        if ( endIdx < startIdx ){
            return null;
        }

        TreeNode curr = new TreeNode(nums[midpoint]);

        curr.left = getSubBST(nums, startIdx, (midpoint - 1));
        curr.right = getSubBST(nums, (midpoint + 1), endIdx);

        return curr;
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        int [] testcase = new int[]{-10,-3,0,5,9};
        TreeNode tc = sol.sortedArrayToBST(testcase);
        List<Integer> tcList = TreeUtils.treeToIntegerList(tc, testcase.length);
        ListUtils.printIntegerList(tcList);

        //tc2
        // int [] testcase = new int[]{1, 3};
        // TreeNode tc = sol.sortedArrayToBST(testcase);
        // List<Integer> tcList = sol.treeToList(tc, testcase.length);
        // sol.printList(tcList);

    }
}