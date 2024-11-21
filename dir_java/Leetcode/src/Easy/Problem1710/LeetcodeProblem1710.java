package src.Easy.Problem1710;

import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(
            boxTypes, 
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o2[1], o1[1]);
                }
            }
        );


        int maxNumUnits = 0;
        int remainingTruckBoxSpace = truckSize;
        int currIdx = 0;

        while ( ( remainingTruckBoxSpace != 0 ) && ( currIdx < boxTypes.length ) ){
            int maxUnitBoxTypeIdx = currIdx;
            int maxUnitBoxTypeNumBoxes = boxTypes[maxUnitBoxTypeIdx][0];
            int maxUnitNumUnitsPerBox = boxTypes[maxUnitBoxTypeIdx][1];

            if ( maxUnitBoxTypeNumBoxes <= remainingTruckBoxSpace ){
                maxNumUnits = maxNumUnits + maxUnitBoxTypeNumBoxes * maxUnitNumUnitsPerBox;
                remainingTruckBoxSpace = remainingTruckBoxSpace - maxUnitBoxTypeNumBoxes;
            }

            else { 
                maxNumUnits = maxNumUnits + remainingTruckBoxSpace * maxUnitNumUnitsPerBox;
                remainingTruckBoxSpace = 0;
            }

            currIdx = currIdx + 1;

        }

        return maxNumUnits;
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();
        int [][] tc = new int[][]{
            {1,3},
            {2,2},
            {3,1}
        };
        int tcTruckSize = 4;
        int maximumUnits = sol.maximumUnits(tc, tcTruckSize);
        System.out.println(maximumUnits);

        System.out.println("\n");
        System.out.println("#################");
        System.out.println(" New Test Case ");
        System.out.println("##################");
        System.out.println("\n");


        //boxTypes = , truckSize = 10
        int [][] tc2 = new int[][]{
            {5,10},
            {2,5},
            {4,7},
            {3,9}
        };
        int tcTruckSize2 = 10;
        int maximumUnits2 = sol.maximumUnits(tc2, tcTruckSize2);
        System.out.println(maximumUnits2);

        System.out.println("\n");
        System.out.println("#################");
        System.out.println(" New Test Case ");
        System.out.println("##################");
        System.out.println("\n");

        int [][] tc3 = new int[][]{
            {1,3},
            {5,5},
            {2,5},
            {4,2},
            {4,1},
            {3,1},
            {2,2},
            {1,3},
            {2,5},
            {3,2}
        };
        int tcTruckSize3 = 35;
        int maximumUnits3 = sol.maximumUnits(tc3, tcTruckSize3);
        System.out.println(maximumUnits3);

    }
}