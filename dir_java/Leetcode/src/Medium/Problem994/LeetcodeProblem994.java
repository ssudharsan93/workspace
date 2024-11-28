package src.Medium.Problem994;

import java.util.*;
import src.common.ListUtils;

class Solution {
    public int orangesRotting(int[][] grid) {
        int numSteps = 0;
        int numOnes = 0;
        int numTwos = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++){
                if ( grid[i][j] == 1 ) {
                    if ( checkIfIsolated(grid, i, j) ) {
                        return -1;
                    }
                    numOnes++;
                } else if ( grid[i][j] == 2 ) {
                    numTwos++;
                }
            }
        }

        if ( numOnes == 0 ) {
            return 0;
        }

        if ( numTwos == 0 ) {
            return -1;
        }

        int prevNumOnes = numOnes;

        while ( numOnes > 0 ) {
            int[][] gridCopy = copyGrid(grid);

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++){
                    if ( grid[i][j] == 2 ){
                        int numAffected = numOrangesAffected(gridCopy, i, j);
                        if ( numAffected > 0 ) {
                            numOnes = numOnes - numAffected;
                            gridCopy = spreadRot(gridCopy, i, j);
                        }
                    }
                }
            }

            if ( numOnes == prevNumOnes ) {
                return -1;
            }

            numSteps = numSteps + 1;
            grid = gridCopy;
            prevNumOnes = numOnes;
        }

        return numSteps;
    }

    public int[][] copyGrid(int[][] grid) {
        int[][] gridCopy = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++){
                gridCopy[i][j] = grid[i][j];
            }
        }

        return gridCopy;
    }

    public boolean checkIfIsolated(int[][] grid, int i, int j){
        boolean isLowerSquareEmpty = false;
        boolean isRightSquareEmpty = false;
        boolean isUpperSquareEmpty = false;
        boolean isLeftSquareEmpty = false;

        if ( ( i + 1 ) <= ( grid.length - 1 ) ){
            isLowerSquareEmpty = ( grid[ i + 1 ][j] == 0 );
        } else { 
            isLowerSquareEmpty = true;
        }

        if ( ( j + 1 ) <= ( grid[i].length - 1 ) ){
            isRightSquareEmpty = ( grid[i][ j + 1 ] == 0 );
        } else { 
            isRightSquareEmpty = true;
        }

        if ( ( i - 1 ) >=  0 ){
            isUpperSquareEmpty = ( grid[ i - 1 ][j] == 0 );
        } else { 
            isUpperSquareEmpty = true;
        }

        if ( ( j - 1 ) >= 0 ){
            isLeftSquareEmpty = ( grid[i][ j - 1 ] == 0 );
        } else { 
            isLeftSquareEmpty = true;
        }

        return isLowerSquareEmpty && isRightSquareEmpty && isUpperSquareEmpty && isLeftSquareEmpty;
    }

    public int numOrangesAffected(int[][] grid, int i, int j){
        int count = 0;

        if ( ( i + 1 ) <= ( grid.length - 1 ) ) {
            if ( grid[ i + 1 ][j] == 1 ) {
                count = count + 1;
            }
        }

        if ( ( j + 1 ) <= ( grid[i].length - 1 ) ){
            if ( grid[i][ j + 1 ] == 1 ) {
                count = count + 1;
            }
        }

        if ( ( i - 1 ) >=  0 ){
            if ( grid[ i - 1 ][j] == 1 ) {
                count = count + 1;
            }
        }

        if ( ( j - 1 ) >= 0 ){
            if ( grid[i][ j - 1 ] == 1 ) {
                count = count + 1;
            }
        }

        return count;
    }

    public int[][] spreadRot(int[][] grid, int i, int j){
        if ( ( i + 1 ) <= ( grid.length - 1 ) ){
            if ( grid[ i + 1 ][j] == 1 ) {
                grid[ i + 1 ][j] = 2;
            }
        }

        if ( ( j + 1 ) <= ( grid[i].length - 1 ) ){
            if ( grid[i][ j + 1 ] == 1 ) {
                grid[i][ j + 1 ] = 2;
            }
        }

        if ( ( i - 1 ) >=  0 ){
            if ( grid[ i - 1 ][j] == 1 ) {
                grid[ i - 1 ][j] = 2;
            }
        }

        if ( ( j - 1 ) >= 0 ){
            if ( grid[i][ j - 1 ] == 1 ) {
                grid[i][ j - 1 ] = 2;
            }
        }

        return grid;
    }

    public void printGrid(int[][] grid){
        for (int i = 0; i < grid.length; i++){
            System.out.print("\n");
            System.out.print("[");
            for (int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }



    public static void main(String[] args){
        Solution sol = new Solution();
        int [][] tc = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        sol.printGrid(tc);
        int res = sol.orangesRotting(tc);
        System.out.println(res);

        int [][] tc2 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        sol.printGrid(tc2);
        int res2 = sol.orangesRotting(tc2);
        System.out.println(res2);
    }
}