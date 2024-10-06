package src.Easy.common;

import java.util.*;

public class TreeUtils {
    public static void printTree(TreeNode root){

        if ( root == null ){
            System.out.println(" ");
            return;
        }

        LinkedList<TreeNode> toBeProcessed = new LinkedList<>();
        toBeProcessed.add(root);

        System.out.print("Depth 0 :\t");
        System.out.print(root.val);

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