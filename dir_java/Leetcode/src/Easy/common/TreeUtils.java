package src.Easy.common;

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

    public static List<Integer> treeToList(TreeNode root, int numNodes){
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
}