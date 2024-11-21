package src.Easy.Problem1710;

import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int numOps = 0;

        int currMinVal = getMinElement(nums);
        
        while ( currMinVal != Integer.MAX_VALUE ){
            nums = updateArray(nums, currMinVal);
            numOps = numOps + 1;
            currMinVal = getMinElement(nums);
        }

        return numOps;
    }

    public int[] updateArray(int[] nums, int currMinVal){
        for ( int arrIdx = 0; arrIdx < nums.length; arrIdx++ ){
            if ( nums[arrIdx] != 0 ){
                nums[arrIdx] = nums[arrIdx] - currMinVal;
            }
        }

        return nums;
    }


    public int getMinElement(int[] nums){
        int minVal = Integer.MAX_VALUE;
        for ( int arrIdx = 0; arrIdx < nums.length; arrIdx++ ){
            if ( nums[arrIdx] != 0 ){
                minVal = Math.min(minVal, nums[arrIdx]);
            }
        }

        return minVal;
    }

    public static void main(String[] args){ 
        Solution sol = new Solution();
        int [] tc = new int[]{1,5,0,3,5};
        int minNumberOperations = sol.minimumOperations(tc);
        System.out.println(minNumberOperations);

        int [] tc2 = new int[]{0};
        int minNumberOperations2 = sol.minimumOperations(tc);
        System.out.println(minNumberOperations2);

    }
}