package src.Easy.Problem104;

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

    public TreeNode buildTree(List<Integer> input){

        if ( input == null || input.size() == 0 ){
            return null;
        }

        TreeNode [] nodes = new TreeNode[input.size()];
        TreeNode curr;
        int leftChildIdx, rightChildIdx;

        int currDepth = 0;
        int numNodesProcessed = 0;
        int childrenAssigned = 0;
        
        for ( int buildIdx = 0; buildIdx < input.size(); buildIdx++ ){
            if ( nodes[buildIdx] == null ){    
                if ( input.get(buildIdx) != null ){
                    nodes[buildIdx] = new TreeNode(input.get(buildIdx).intValue());
                }
            }
            
            if ( nodes[buildIdx] != null ){
                int childStartIdx = (int) Math.pow(2, currDepth + 1) - 1;
                int maxNumNodesNextDepth = (int) Math.pow(2, currDepth + 1);

                /*
                System.out.println(nodes[buildIdx].val);
                System.out.println("\t\tCurrent Depth: " + currDepth);
                System.out.println("\t\tChild Start Index: " + childStartIdx);
                System.out.println("\t\tChild End Index: " + ( childStartIdx + ( maxNumNodesNextDepth - 1 ) ) );
                System.out.println("\t\tChild Assigned So Far: " + childrenAssigned);
                */

                for ( int childIdx = childStartIdx + childrenAssigned; childIdx < childStartIdx + maxNumNodesNextDepth; childIdx++ ){
                    if ( childIdx < input.size() ) {
                        if ( input.get(childIdx) != null ){
                            nodes[childIdx] = new TreeNode(input.get(childIdx).intValue());    
                        }
                        if ( ( childrenAssigned % 2 ) == 0 ){ 
                            nodes[buildIdx].left = nodes[childIdx];
                            childrenAssigned = childrenAssigned + 1;
                        } else { 
                            nodes[buildIdx].right = nodes[childIdx];
                            childrenAssigned = childrenAssigned + 1;
                            break;
                        }
                    }
                }

                /*
                System.out.println(nodes[buildIdx].val);
                if ( nodes[buildIdx].left != null ){
                    System.out.println("\tLeft Child Value: " + nodes[buildIdx].left.val);
                } else { 
                    System.out.println("\tLeft Child Value: null");
                }

                if ( nodes[buildIdx].right != null ){
                    System.out.println("\tRight Child Value: " + nodes[buildIdx].right.val);
                } else { 
                    System.out.println("\tRight Child Value: null");
                }
                */
            }

            numNodesProcessed = numNodesProcessed + 1;
            if ( numNodesProcessed == ( (int) Math.pow(2, currDepth + 1) - 1 ) ){
                currDepth = currDepth + 1;
                childrenAssigned = 0;
            }
        }

        return nodes[0];
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
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(3,9,20,null,null,15,7));
        // sol.printList(testcase);
        // TreeNode tcRoot = sol.buildTree(testcase);
        // System.out.println(sol.maxDepth(tcRoot));
        
        //tc2
        // List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,null,2));
        // sol.printList(testcase);
        // TreeNode tcRoot = sol.buildTree(testcase);
        // System.out.println(sol.maxDepth(tcRoot));

        //tc2
        List<Integer> testcase = new ArrayList<Integer>(Arrays.asList(1,2));
        sol.printList(testcase);
        TreeNode tcRoot = sol.buildTree(testcase);
        System.out.println(sol.maxDepth(tcRoot));


    }
}