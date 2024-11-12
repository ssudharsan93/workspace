package src.Easy.Problem144;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;
import src.common.ListUtils;

class Solution {
    public List<Integer> preOrderTraversal(TreeNode root) {
        return recursiveSolution(root, new ArrayList<Integer>());
    }
    
    public List<Integer> recursiveSolution(TreeNode curr, List<Integer> result){
        if ( curr == null ){
            return result;
        }

        result.add(Integer.valueOf(curr.val));

        if ( curr.left != null ){
            result = recursiveSolution(curr.left, result);
        }

        if ( curr.right != null ){
            result = recursiveSolution(curr.right, result);
        }
        
        return result;
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();
        
        //List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,null,2,3));
        List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,9));
        //List<Integer> testcase = new ArrayList<Integer>(Arrays.asList());
        //List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1));

        ListUtils.printList(testcase);

        System.out.println("");

        TreeNode testcaseRoot = TreeBuilder.buildTree(testcase);

        System.out.println("");

        List<Integer> result = sol.preOrderTraversal(testcaseRoot);

        ListUtils.printList(result);
        
    }
}