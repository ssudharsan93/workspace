package src.Easy.Problem94;

import java.util.*;
import src.common.TreeNode;
import src.common.TreeBuilder;
import src.common.TreeUtils;
import src.common.ListUtils;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return recursiveSolution(root, new ArrayList<Integer>());
    }
    
    public List<Integer> recursiveSolution(TreeNode curr, List<Integer> result){
        if ( curr == null ){
            return result;
        }

        /*
        if ( curr != null ){
            System.out.println(curr.val);
            if ( curr.left != null ){
                System.out.println("\tLeft Child Value: " + curr.left.val);
            } else { 
                System.out.println("\tLeft Child Value: null");
            }

            if ( curr.right != null ){
                System.out.println("\tRight Child Value: " + curr.right.val);
            } else { 
                System.out.println("\tRight Child Value: null");
            }
        }
        */

        if ( curr.left != null ){
            result = recursiveSolution(curr.left, result);
        }

        result.add(Integer.valueOf(curr.val));

        if ( curr.right != null ){
            result = recursiveSolution(curr.right, result);
        }
        
        return result;
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();
        
        List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,null,2,3));
        //List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,null,8,null,null,6,7,9));
        //List<Integer> testcase = new ArrayList<Integer>(Arrays.asList());
        //List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1));

        ListUtils.printIntegerList(testcase);

        System.out.println("");

        TreeNode testcaseRoot = TreeBuilder.buildTree(testcase);

        System.out.println("");

        List<Integer> result = sol.inorderTraversal(testcaseRoot);

        ListUtils.printIntegerList(result);
        
    }
}