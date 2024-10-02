package src.Easy.Problem108;

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
        // int [] testcase = new int[]{-10,-3,0,5,9};
        // TreeNode tc = sol.sortedArrayToBST(testcase);
        // List<Integer> tcList = sol.treeToList(tc, testcase.length);
        // sol.printList(tcList);

        //tc2
        int [] testcase = new int[]{1, 3};
        TreeNode tc = sol.sortedArrayToBST(testcase);
        List<Integer> tcList = sol.treeToList(tc, testcase.length);
        sol.printList(tcList);

    }
}