package src.Hard.Problem42;

//TODO
//Need to write a description of why this algorithm works.
// Also need to enumerate the key steps of this algorithm.

//https://leetcode.com/problems/trapping-rain-water/description/

// In order to solve this problem we need to determine at each position
// how much water can feasibly be stored.

// We do this by determining the maximum height seen by a particular index
// from the left and from the right. This is because we need to know if there
// this current index is the highest column seen from both left and right or
// the minimum of the highest columns seen from the left and the right. In either
// case the amount of water that would be stored would be 0.

// Rain can only collect between two columns and rises to the height of the 
// smaller of the two columns.

// In order to accomplish this we first need to determine the maximum height
// seen from the right and from the left for each index, up until that index.
// i.e. left[i] and right[i] are the maximum height seen from the left and
// from the right respectively at index i coming from those respective directions.
// left[i] is the maximum height seen from 0 to i and right[i] is the maximum
// height seen from i to the end of the array.

// The algorithm is as follows:
// 1. Initialize left[0] = height[0] and right[length-1] = height[length-1] ( These are 
// the maximum heights seen from the left and from the right respectively at index 0 i.e.
// the very first column and the very last column. )
// 2. For each index i, determine the maximum height seen from the left and from the right
// and store them in left[i] and right[i] respectively. These are two separate arrays and are
// populated in two separate forloops.
// 3. For each index i, determine the amount of water that can be collected at index i based on 
// the maximum height seen from the left and from the right. The amount of water that can be
// collected is the minimum of the two heights minus the height at index i. This is because
// the amount of water that can be collected at that specific point is the height of the column
// at that point which forms the base of the water up till the height of the lower of the two columns
// seen from the left and from the right at index i.
// 4. Return the total amount of water that can be collected.

class Solution {
    public int trap(int[] height) {
        int [] left = new int[height.length];
        int [] right = new int[height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];

        for (int i = 1; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        for (int i = height.length-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < height.length; i++){
            int currTrappedWatter = Math.min(left[i], right[i]) - height[i];
            totalWater += currTrappedWatter;

        }
        return totalWater;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int [] tc1Height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};  
        System.out.println(sol.trap(tc1Height));
    }
}