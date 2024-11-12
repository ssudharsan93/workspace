package src.Easy.Problem136;

import java.util.*;
import java.math.BigInteger;
import src.common.ListUtils;
import src.common.MathUtils;

class Solution {
    public int singleNumber(int[] nums) {
        
        if ( nums.length == 1 ){
            return nums[0];
        }

        int singleNum = 0;
        for ( int numsIdx = 0; numsIdx < nums.length; numsIdx++ ){
            singleNum = singleNum ^ nums[numsIdx]; // ^ is the exclusive or operator.
                                                   // Lets say there are 5 elements, a, b, c, d, e
                                                   // If you exclusive or all of the 5 elements with each other
                                                   // they can be rearranged in any particular way. 
                                                   // Additionally if two elements are equal, the result of the
                                                   // exclusive or operation is 0.
                                                   // Any number exclusive or'ed with 0 is itself.
                                                   // therefore simply going through and exclusive or'ing every
                                                   // number with 0 will produce the one unique number.
        }

        return singleNum;
    }


    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        int [] tc1 = new int[]{4,1,2,1,2};
        System.out.println(sol.singleNumber(tc1));

        //tc2
        int [] tc2 = new int[]{2,2,1};
        System.out.println(sol.singleNumber(tc2));

        //tc3
        int [] tc3 = new int[]{1};
        System.out.println(sol.singleNumber(tc3));

    }
}