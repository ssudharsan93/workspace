package src.Medium.Problem994;

import java.util.*;
import src.common.ListUtils;

//TODO
//Need to reimplement this algorithm and change it
// from duplicating an array to using instead a Deque
// that keeps track of the rotten oranges found on this loop.

class Solution {
    public int orangesRotting(int[][] grid) {
        int numSteps = 0;
        int numOnes = 0;
        int numTwos = 0;

        Deque<int[]> rottenOrangeLocations = new ArrayDeque<int[]>(); 

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++){
                if ( grid[i][j] == 1 ) {
                    if ( checkIfIsolated(grid, i, j) ) {
                        return -1;
                    }
                    numOnes++;
                } else if ( grid[i][j] == 2 ) {
                    numTwos++;
                    rottenOrangeLocations.addLast(new int[]{i, j});
                }
            }
        }

        // Adding delimiter
        rottenOrangeLocations.addLast(new int[]{-1, -1});

        if ( numOnes == 0 ) {
            return 0;
        }

        if ( numTwos == 0 ) {
            return -1;
        }

        int prevNumOnes = numOnes;

        int[] rottenOrangeLocation = rottenOrangeLocations.removeFirst();
        int i = rottenOrangeLocation[0];
        int j = rottenOrangeLocation[1];
        
        //Deque version
        while ( numOnes > 0 ){
            while ( ( i != -1 ) && ( j != -1 ) ) {
                List<int[]> getRipeOrangeLocationsAffected = getRipeOrangeLocationsAffected(grid, i, j);
                int numAffected = getRipeOrangeLocationsAffected.size();


                if ( numAffected > 0 ) {
                    numOnes = numOnes - numAffected;
                    grid = spreadRot(grid, i, j);
                }

                rottenOrangeLocations.addLast(rottenOrangeLocation);
                rottenOrangeLocations = addNewRottenOrangeLocations(getRipeOrangeLocationsAffected, rottenOrangeLocations);

                rottenOrangeLocation = rottenOrangeLocations.removeFirst();
                i = rottenOrangeLocation[0];
                j = rottenOrangeLocation[1];
            }

            if ( numOnes == prevNumOnes ) {
                return -1;
            }

            // Adding back delimiter
            rottenOrangeLocations.addLast(rottenOrangeLocation);
            rottenOrangeLocation = rottenOrangeLocations.removeFirst();
            i = rottenOrangeLocation[0];
            j = rottenOrangeLocation[1];

            numSteps = numSteps + 1;
            prevNumOnes = numOnes;
        }

        return numSteps;
    }

    public Deque<int[]> addNewRottenOrangeLocations(List<int[]> newRottenOrangeLocations, Deque<int[]> rottenOrangeLocations){
        for (int[] rottenOrangeLocation : newRottenOrangeLocations) {
            if ( !rottenOrangeLocations.contains(rottenOrangeLocation) ) {
                rottenOrangeLocations.addLast(rottenOrangeLocation);   
            }
        }
        return rottenOrangeLocations;
    }

    public List<int[]> getRipeOrangeLocationsAffected(int[][] grid, int i, int j){
        List<int[]> affectedRipeOrangeLocations = new ArrayList<int[]>();

        if ( ( i + 1 ) <= ( grid.length - 1 ) ) {
            if ( grid[ i + 1 ][j] == 1 ) {
                affectedRipeOrangeLocations.add(new int[]{i + 1, j});
            }
        }

        if ( ( j + 1 ) <= ( grid[i].length - 1 ) ){
            if ( grid[i][ j + 1 ] == 1 ) {
                affectedRipeOrangeLocations.add(new int[]{i, j + 1});
            }
        }

        if ( ( i - 1 ) >=  0 ){
            if ( grid[ i - 1 ][j] == 1 ) {
                affectedRipeOrangeLocations.add(new int[]{i - 1, j});
            }
        }

        if ( ( j - 1 ) >= 0 ){
            if ( grid[i][ j - 1 ] == 1 ) {
                affectedRipeOrangeLocations.add(new int[]{i, j - 1});
            }
        }

        return affectedRipeOrangeLocations;
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

    public int altOrangesRotting(int[][] grid) {
        int numSteps = 0;
        int numOnes = 0;
        int numTwos = 0;

        Deque<int[]> rottenOrangeLocations = new ArrayDeque<int[]>(); 

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

        //Array version ( worse time complexity than deque )
        while ( numOnes > 0 ) {
            int[][] gridCopy = copyGrid(grid);

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++){
                    if ( grid[i][j] == 2 ){
                        int numAffected = altNumOrangesAffected(gridCopy, i, j);
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

    public int altNumOrangesAffected(int[][] grid, int i, int j){
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

    public int[][] copyGrid(int[][] grid) {
        int[][] gridCopy = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++){
                gridCopy[i][j] = grid[i][j];
            }
        }

        return gridCopy;
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
        int res = sol.orangesRotting(tc);
        //int res = sol.altOrangesRotting(tc);
        System.out.println(res);

        int [][] tc2 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int res2 = sol.orangesRotting(tc2);
        //int res2 = sol.altOrangesRotting(tc2);
        System.out.println(res2);

        int [][] tc3 = new int[][]{{2},{2},{1},{0},{1},{1}};
        int res3 = sol.orangesRotting(tc3);
        //int res3 = sol.altOrangesRotting(tc3);
        System.out.println(res3);
    }
}