package src.common;

import java.util.*;
import src.common.TreeNode;

public class ListUtils {
    public static void printIntegerList(List<Integer> input){

        if ( input == null ){
            System.out.print("[ ]");
            return;
        }

        System.out.print("[ ");
        for ( int printIdx = 0; printIdx < input.size(); printIdx++ ){
            Integer curr = input.get(printIdx);
            if ( curr != null ){
                System.out.print(curr);
            }
            else { 
                System.out.print("null");
            }
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void printStringList(List<String> input){

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

    public static void printTreeNodeList(List<TreeNode> input){

        if ( input == null ){
            System.out.print("[ ]");
            return;
        }

        System.out.print("[ ");
        for ( int printIdx = 0; printIdx < input.size(); printIdx++ ){
            TreeNode curr = input.get(printIdx);
            if ( curr != null ){
                System.out.print(curr.val);
            }
            else { 
                System.out.print("null");
            }
            System.out.print(" ");
        }
        System.out.println("]");
    }
}