package src.Easy.Problem118;

import java.util.*;
import java.math.BigInteger;
import src.common.ListUtils;
import src.common.MathUtils;

class Solution {

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
        // int numRows = 5;
        // List<List<Integer>> result = sol.generate(numRows);
        // sol.printListofLists(result);

        //tc2
        // int numRows = 3;
        // List<List<Integer>> result = sol.generate(numRows);
        // sol.printListofLists(result);

        //tc3
        // int numRows = 7;
        // List<List<Integer>> result = sol.generate(numRows);
        // sol.printListofLists(result);

        //tc4
        int numRows = 14;
        List<List<Integer>> result = sol.generate(numRows);
        sol.printListofLists(result);

    }
}