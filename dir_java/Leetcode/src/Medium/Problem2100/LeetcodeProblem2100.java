package src.Medium.Problem2100;

import java.util.*;
import src.common.ListUtils;

class Solution {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int [] nonIncreasingCounts = new int[security.length];
        int [] nonDecreasingCounts = new int[security.length];
        int nonIncreasingGuardCount = 1;
        int nonDecreasingGuardCount = 1;

        nonIncreasingCounts[0] = nonIncreasingGuardCount;
        nonDecreasingCounts[security.length - 1] = nonDecreasingGuardCount;

        for (int i = 1; i < security.length; i++){
            if ( security[i-1] >= security[i] ) {
                nonIncreasingGuardCount += 1;
            } 
            else {
                nonIncreasingGuardCount = 0;
            }
            nonIncreasingCounts[i] = nonIncreasingGuardCount;

        }

        for (int i = security.length - 2; i >= 0; i--){
            if ( security[i] <= security[i+1] ) {
                nonDecreasingGuardCount += 1;
            } 
            else {
                nonDecreasingGuardCount = 0;
            }

            nonDecreasingCounts[i] = nonDecreasingGuardCount;
        }

        //System.out.println(Arrays.toString(nonIncreasingCounts) + "\n" + Arrays.toString(nonDecreasingCounts));

        List<Integer> result = new ArrayList<>();
        for (int i = time; i < security.length - time; i++){
            if ( time == 0 ) { 
                result.add(i); 
                continue; 
            }
            
            if ( nonIncreasingCounts[i] >= time && nonDecreasingCounts[i] >= time ){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        // security = [5,3,3,3,5,6,2], time = 2
        int [] security = new int[]{5,3,3,3,5,6,2};
        int time = 2;
        List<Integer> result = sol.goodDaysToRobBank(security, time);
        ListUtils.printIntegerList(result);

        //security = [1,1,1,1,1], time = 0
        int [] security2 = new int[]{1,1,1,1,1};
        int time2 = 0;
        List<Integer> result2 = sol.goodDaysToRobBank(security2, time2);
        ListUtils.printIntegerList(result2);

        //security = [1,1,1,1,1], time = 0
        int [] security3 = new int[]{1,2,3,4};
        int time3 = 1;
        List<Integer> result3 = sol.goodDaysToRobBank(security3, time3);
        ListUtils.printIntegerList(result3);

        //[1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8]
        int [] security4 = new int[]{1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8};
        int time4 = 2;
        List<Integer> result4 = sol.goodDaysToRobBank(security4, time4);
        ListUtils.printIntegerList(result4);
    }
}