package src.Easy.Problem121;

import java.util.*;
import java.math.BigInteger;
import src.common.ListUtils;
import src.common.MathUtils;

class Solution {
    public int maxProfit(int[] prices) {

        int currMaxProfit = 0;

        if ( prices.length == 1 ){
            return currMaxProfit;
        }

        int buyIdx = 0;
        for ( int sellIdx = buyIdx + 1; sellIdx < prices.length; sellIdx++ ){

            if ( prices[sellIdx] < prices[buyIdx] ){
                buyIdx = sellIdx;
                continue;
            }

            currMaxProfit = Math.max(currMaxProfit, prices[sellIdx] - prices[buyIdx]);

        }

        return currMaxProfit;
    }


    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        int [] prices = new int[]{7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices));

        //tc2
        int [] prices2 = new int[]{7,6,4,3,1};
        System.out.println(sol.maxProfit(prices2));

    }
}