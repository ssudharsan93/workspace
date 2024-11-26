package src.common;

import java.util.*;

public class TreeUtils {
    public static void printTree(TreeNode root){

        if ( root == null ){
            System.out.println(" ");
            return;
        }

        LinkedList<TreeNode> toBeProcessed = new LinkedList<>();
        LinkedList<TreeNode> processing = new LinkedList<>();
        Set<TreeNode> nodesAtDepth = new HashSet<TreeNode>();

        toBeProcessed.add(root);

        int depth = 0;

        while ( !toBeProcessed.isEmpty() ){
            int numNodesToBeProcessed = toBeProcessed.size();

            for ( int queueIdx = 0; queueIdx < numNodesToBeProcessed; queueIdx++ ){
                TreeNode nodeToBeProcessed = toBeProcessed.removeLast();
                processing.addFirst(nodeToBeProcessed);
                nodesAtDepth.add(nodeToBeProcessed);
            }

            if ( ( nodesAtDepth.size() == 1 ) && ( nodesAtDepth.contains(null) ) ){ break; }
            
            System.out.println("");
            System.out.println("Depth " + depth + " :\t");
            
            while ( !processing.isEmpty() ){
                TreeNode curr = processing.removeLast();

                if ( curr == null ) {
                    System.out.print("null");
                    System.out.print("\t");
                    toBeProcessed.addFirst(null);
                    toBeProcessed.addFirst(null);
                    continue;
                }

                System.out.print(curr.val);
                System.out.print("\t");

                toBeProcessed.addFirst(curr.left);
                toBeProcessed.addFirst(curr.right);
            }

            depth = depth + 1;
            nodesAtDepth.clear();
        }

        System.out.println("\n");

    }

    public LinkedList<LinkedList<TreeNode>> altBFSTraversal(TreeNode root){
        if ( root == null ){ return null; }

        LinkedList<TreeNode> toProcess = new LinkedList<TreeNode>();
        LinkedList<TreeNode> processingNow = new LinkedList<TreeNode>();
        LinkedList<LinkedList<TreeNode>> listTraversedNodes = new LinkedList<>();

        toProcess.addLast(root);
        TreeNode curr;

        LinkedList<TreeNode> currDepthNodes = new LinkedList<TreeNode>();

        while ( !toProcess.isEmpty() ){
            processingNow.addLast(toProcess.removeFirst());

            if ( toProcess.isEmpty() ){
                while ( !processingNow.isEmpty() ) {
                    curr = processingNow.removeFirst();
                    currDepthNodes.addLast(curr);

                    if ( processingNow.isEmpty() ){
                        listTraversedNodes.add(currDepthNodes);
                        currDepthNodes = new LinkedList<TreeNode>();
                    }

                    if ( curr.left != null ){
                        toProcess.addLast(curr.left);
                    }

                    if ( curr.right != null ){
                        toProcess.addLast(curr.right);
                    }
                }
            }
        }

        return listTraversedNodes;
    }

    public static List<TreeNode> bfsTraversal(TreeNode root, int numNodes){
        if ( root == null || numNodes == 0 ){ return null; }
        
        List<TreeNode> sol = new ArrayList<>();
        LinkedList<TreeNode> toBeProcessed = new LinkedList<>();
        toBeProcessed.addFirst(root);

        TreeNode curr;

        for ( int treeIdx = 0; treeIdx < numNodes; ){
            curr = toBeProcessed.removeLast();
            if ( curr != null ){
                sol.add(curr);
                toBeProcessed.addFirst(curr.left);
                toBeProcessed.addFirst(curr.right);
            } else {
                sol.add(null);
            }

            treeIdx = treeIdx + 1;
        }

        toBeProcessed = null;

        return sol;
    }

    public static List<Integer> treeToIntegerList(TreeNode root, int numNodes){
        List<TreeNode> bfsTraversedNodes = new ArrayList<TreeNode>(TreeUtils.bfsTraversal(root, numNodes));
        List<Integer> intList = new ArrayList<Integer>();

        TreeNode curr;
        for ( int listIdx = 0; listIdx < numNodes; listIdx++ ){
            curr = bfsTraversedNodes.get(listIdx);
            if ( curr != null ){ 
                intList.add(Integer.valueOf(curr.val));
            } else { 
                intList.add(null);
            }
        }

        return intList;

    }

    public static TreeNode getNode(TreeNode root, int numNodes, int target){
        List<TreeNode> bfsTraversedNodes = new ArrayList<TreeNode>(TreeUtils.bfsTraversal(root, numNodes));

        TreeNode curr;

        for ( int listIdx = 0; listIdx < numNodes; listIdx++ ){
            curr = bfsTraversedNodes.get(listIdx);
            if ( curr.val == target ) {
                return curr;
            }
        }

        return null;
    }
}