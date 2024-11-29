package src.Medium.Problem2100;

import java.util.*;
import src.common.ListUtils;

class Solution {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        // security = [5,3,3,3,5,6,2], time = 2
        int [] security = new int[]{5,3,3,3,5,6,2};
        int time = 2;
        List<Integer> result = sol.goodDaysToRobBank(security, time);
        ListUtils.printIntegerList(result);

        //security = [1,1,1,1,1], time = 0
        security = new int[]{1,1,1,1,1};
        time = 0;
        result = sol.goodDaysToRobBank(security, time);
        ListUtils.printIntegerList(result);
    }
}