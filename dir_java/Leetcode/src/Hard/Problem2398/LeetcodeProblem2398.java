package src.Hard.Problem2398;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int leftIdx = 0;
        int rightIdx = 0;
        int maxRobots = 0;

        long runningCostSum = runningCosts[leftIdx];
        long totalCost = chargeTimes[leftIdx] + ( rightIdx - leftIdx + 1 ) * runningCostSum;
        int totalRobots = 0;

        PriorityQueue<Integer> maxChargeTimesCurrentWindow = new PriorityQueue<Integer>(Comparator.reverseOrder());
        maxChargeTimesCurrentWindow.add(chargeTimes[leftIdx]);
        int currentMaxChargeTime = chargeTimes[leftIdx];

        while ( rightIdx < chargeTimes.length ) {
            // System.out.println("leftIdx: " + leftIdx);
            // System.out.println("rightIdx: " + rightIdx);
            // System.out.println("totalCost: " + totalCost);
            // System.out.println("budget: " + budget);
            
            if ( totalCost > budget ) {
                maxChargeTimesCurrentWindow.remove(chargeTimes[leftIdx]);
                runningCostSum = runningCostSum - runningCosts[leftIdx];
                leftIdx = leftIdx + 1;

                if ( leftIdx > rightIdx ) {
                    rightIdx = rightIdx + 1;
                    if ( rightIdx == chargeTimes.length ) {
                        break;
                    }
                    runningCostSum = runningCostSum + runningCosts[leftIdx];
                    maxChargeTimesCurrentWindow.add(chargeTimes[leftIdx]);
                }

                currentMaxChargeTime = maxChargeTimesCurrentWindow.peek();
                totalCost = (long)currentMaxChargeTime + runningCostSum * ( rightIdx - leftIdx + 1 );
                totalRobots = 0;
            }

            else {
                totalRobots = rightIdx - leftIdx + 1;
                maxRobots = Math.max(maxRobots, totalRobots);
                //System.out.println("totalRobots: " + totalRobots);
                //System.out.println("maxRobots: " + totalRobots);

                rightIdx = rightIdx + 1;
                if ( rightIdx == chargeTimes.length ) { 
                    break;
                }
                runningCostSum = runningCostSum + runningCosts[rightIdx];
                maxChargeTimesCurrentWindow.add(chargeTimes[rightIdx]);
                currentMaxChargeTime = maxChargeTimesCurrentWindow.peek();
                totalCost = (long)currentMaxChargeTime + runningCostSum * ( rightIdx - leftIdx + 1 );
            }
        }

        return maxRobots;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        // //chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
        // int [] chargeTimes = new int[]{3,6,1,3,4};  
        // int [] runningCosts = new int[]{2,1,3,4,5};  
        // long budget = 25;  
        // System.out.println(sol.maximumRobots(chargeTimes, runningCosts, budget));

        // System.out.println("\n#### New Test Case ####\n");
        // //chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
        // int [] chargeTimes2 = new int[]{11,12,19};  
        // int [] runningCosts2 = new int[]{10,8,7};  
        // long budget2 = 19;  
        // System.out.println(sol.maximumRobots(chargeTimes2, runningCosts2, budget2));

        System.out.println("\n#### New Test Case ####\n");

        String chargeTimeFilePath = "src/Hard/Problem2398/chargeTimesTestCase3.txt";
        String runningCostFilePath = "src/Hard/Problem2398/runningCostsTestCase3.txt";

        File chargeTimesFile = new File(chargeTimeFilePath); 
        File runningCostsFile = new File(runningCostFilePath); 

        Scanner chargeTimesScanner;
        Scanner runningCostsScanner;
        String chargeTimesContent = "";
        String runningCostsContent = "";

        try {
            chargeTimesScanner = new Scanner(chargeTimesFile);
            runningCostsScanner = new Scanner(runningCostsFile);

            chargeTimesContent = chargeTimesScanner.next();
            runningCostsContent = runningCostsScanner.next();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        chargeTimesContent = chargeTimesContent.substring(1, chargeTimesContent.length() - 1);
        runningCostsContent = runningCostsContent.substring(1, runningCostsContent.length() - 1);

        String[] chargeTimesArray = chargeTimesContent.split(",");
        String[] runningCostsArray = runningCostsContent.split(",");

        int [] chargeTimes3 = new int[chargeTimesArray.length];
        int [] runningCosts3 = new int[runningCostsArray.length];

        for ( int i = 0; i < chargeTimesArray.length; i++ ) {
            chargeTimes3[i] = Integer.parseInt(chargeTimesArray[i]);
            runningCosts3[i] = Integer.parseInt(runningCostsArray[i]);
        }

        long budget3 = 6564015800L;  
        System.out.println(sol.maximumRobots(chargeTimes3, runningCosts3, budget3));
    }
}