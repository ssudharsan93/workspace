package src.Easy.common;

import java.util.*;

public class TreeBuilder { 
    public static TreeNode buildTree(List<Integer> input){
        if ( input == null || input.size() == 0 ){
            return null;
        }

        int currIdx = 1;

        LinkedList<TreeNode> toBeProcessed = new LinkedList<>();
        TreeNode root = new TreeNode(input.get(0).intValue());
        toBeProcessed.add(root);

        while ( ( currIdx < input.size() ) && !toBeProcessed.isEmpty() ){
            TreeNode curr = toBeProcessed.removeFirst();
            
            if ( curr == null ){ continue; }
            
            curr.left = input.get(currIdx) == null ? null : new TreeNode(input.get(currIdx).intValue());
            toBeProcessed.add(curr.left);

            currIdx = currIdx + 1;
            if ( currIdx == input.size() ){ break; }
            
            curr.right = input.get(currIdx) == null ? null : new TreeNode(input.get(currIdx).intValue());
            toBeProcessed.add(curr.right);

            currIdx = currIdx + 1;
        }

        return root;
    }

}