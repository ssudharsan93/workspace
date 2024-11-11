package src.Easy.Problem119;

import java.util.*;
import java.math.BigInteger;
import src.common.ListUtils;
import src.common.MathUtils;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowSol = new ArrayList<Integer>();
        for ( int colIdx = 0; colIdx <= rowIndex; colIdx++ ){
            int val = MathUtils.nCr(rowIndex, colIdx);
            rowSol.add(val);
        }
        
        return rowSol;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> currentRow = new ArrayList<Integer>();

        if ( numRows <= 0 ){
            solution.add(currentRow);
            return solution;
        }

        for ( int rowIdx = 0; rowIdx < numRows; rowIdx++ ){
            for ( int colIdx = 0; colIdx <= rowIdx; colIdx++ ){
                int val = MathUtils.nCr(rowIdx, colIdx);
                currentRow.add(val);
            }
            solution.add(currentRow);
            currentRow = new ArrayList<Integer>();
        }

        return solution;
    }

    public void printListofLists(List<List<Integer>> input){
        System.out.println("[");
        for ( int listIdx = 0; listIdx < input.size(); listIdx++ ){
            ListUtils.printList(input.get(listIdx));
            System.out.println("");
        }
        System.out.println("]");
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        // int rowIdx = 3;
        // List<Integer> orig = sol.generate(rowIdx + 1).get(rowIdx);
        // List<Integer> result = sol.getRow(rowIdx);
        // ListUtils.printList(orig);
        // ListUtils.printList(result);

        //tc2
        int rowIdx = 4;
        List<Integer> orig = sol.generate(rowIdx + 1).get(rowIdx);
        List<Integer> result = sol.getRow(rowIdx);
        ListUtils.printList(orig);
        ListUtils.printList(result);

        //tc3
        // int rowIdx = 7;
        // List<Integer> orig = sol.generate(rowIdx + 1).get(rowIdx);
        // List<Integer> result = sol.getRow(rowIdx);
        // ListUtils.printList(orig);
        // ListUtils.printList(result);

        //tc4
        // int rowIdx = 5;
        // List<Integer> orig = sol.generate(rowIdx + 1).get(rowIdx);
        // List<Integer> result = sol.getRow(rowIdx);
        // ListUtils.printList(orig);
        // ListUtils.printList(result);

    }
}