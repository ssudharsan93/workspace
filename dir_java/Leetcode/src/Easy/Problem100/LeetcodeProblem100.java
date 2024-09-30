package src.Easy.Problem100;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null || q == null ){
            if ( p == null && q == null ){ return true; }
            else { return false;}
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
        // List<Integer> pInput = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        // List<Integer> qInput = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        // sol.printList(pInput);
        // sol.printList(qInput);
        // TreeNode p = sol.buildTree(pInput);
        // TreeNode q = sol.buildTree(qInput);
        // System.out.println(sol.isSameTree(p, q));

        //tc2
        List<Integer> pInput = new ArrayList<Integer>(Arrays.asList(1, 2));
        List<Integer> qInput = new ArrayList<Integer>(Arrays.asList(1, null, 2));
        sol.printList(pInput);
        sol.printList(qInput);
        TreeNode p = sol.buildTree(pInput);
        TreeNode q = sol.buildTree(qInput);
        System.out.println(sol.isSameTree(p, q));


        //tc3
        // List<Integer> pInput = new ArrayList<Integer>(Arrays.asList(1, 2, 1));
        // List<Integer> qInput = new ArrayList<Integer>(Arrays.asList(1, 1, 2));
        // sol.printList(pInput);
        // sol.printList(qInput);
        // TreeNode p = sol.buildTree(pInput);
        // TreeNode q = sol.buildTree(qInput);
        // System.out.println(sol.isSameTree(p, q));

        
    }
}