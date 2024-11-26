package src.Medium.Problem863;

import java.util.*;
import src.common.TreeBuilder;
import src.common.TreeNode;
import src.common.TreeUtils;
import src.common.ListUtils;

/*
Mapping Parents: We first need a way to traverse the tree not only downwards from the root to the leaves 
(as is normally the case with tree traversals) but also upwards, from any node to its parent. This is not 
usually possible in a binary tree because nodes don't have a reference to their parent. Therefore, we create 
a map that keeps track of each node's parent.

Performing the Search: Once we have the ability to move both up and down the tree, we perform a depth-first 
search (DFS) starting from the target node. As we explore the tree, we keep track of the current distance 
from the target. When this distance equals k, we add the current node's value to our answer.

Avoiding Revisits: To ensure we don't count any nodes twice or enter a loop, we keep a set of visited 
nodes. Whenever we visit a node, we add it to the set. If we encounter a node that's already in our set, 
we skip it.
*/

class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = getParentMap(root);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        return graphLikeDFS(target, k, parentMap, visited, result);
    }

    public List<Integer> graphLikeDFS(
        TreeNode curr, 
        int k, 
        Map<TreeNode, TreeNode> parentMap, 
        Set<TreeNode> visited,
        List<Integer> result
    ) {
    
        if ( k == 0 && !visited.contains(curr) ){
            result.add(Integer.valueOf(curr.val));
            return result;
        }

        if ( visited.contains(curr) ){
            return result;
        } else {
            visited.add(curr);
        }

        if ( ( curr.left != null ) && ( !visited.contains(curr.left) ) ){
            result = modifiedDFS(curr.left, k - 1, parentMap, visited, result);
        }

        if ( ( curr.right != null ) && ( !visited.contains(curr.right) ) ){
            result = modifiedDFS(curr.right, k - 1, parentMap, visited, result);
        }

        if ( ( parentMap.get(curr) != null ) && ( !visited.contains(parentMap.get(curr)) ) ){
            result = modifiedDFS(parentMap.get(curr), k - 1, parentMap, visited, result);
        }

        return result;

    }

    public Map<TreeNode, TreeNode> getParentMap(TreeNode root){
        Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
        LinkedList<TreeNode> toProcess = new LinkedList<TreeNode>();
        parentMap.put(root, null);
        toProcess.addLast(root);

        while ( !toProcess.isEmpty() ){
            TreeNode curr = toProcess.removeFirst();

            if ( curr.left != null ){
                toProcess.addLast(curr.left);
                parentMap.put(curr.left, curr);
            }
            if ( curr.right != null ){
                toProcess.addLast(curr.right);
                parentMap.put(curr.right, curr);
            }
        }

        return parentMap;
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();
        
        //testcase 1
        List<Integer> tcList = new ArrayList<Integer>(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
        int targetNum = 5;
        int k = 2;
        TreeNode tcHead = TreeBuilder.buildTree(tcList);
        TreeNode target = TreeUtils.getNode(tcHead, tcList.size(), targetNum);
        List<Integer> result = sol.distanceK(tcHead, target, k);
        ListUtils.printIntegerList(result);
        
        // testcase 2
        List<Integer> tcList2 = new ArrayList<Integer>(Arrays.asList(1));
        int targetNum2 = 1;
        int k2 = 3;
        TreeNode tcHead2 = TreeBuilder.buildTree(tcList2);
        TreeNode target2 = TreeUtils.getNode(tcHead2, tcList2.size(), targetNum2);
        List<Integer> result2 = sol.distanceK(tcHead2, target2, k2);
        ListUtils.printIntegerList(result2);
    }
}