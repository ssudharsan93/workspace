package src.Hard.Problem42;

#TODO
//Need to write a description of why this algorithm works.
// Also need to enumerate the key steps of this algorithm.

class Solution {
    public int trap(int[] height) {
        int [] left = new int[height.length];
        int [] right = new int[height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];

        for (int i = 1; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        for (int i = height.length-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], height[i+1]);
        }

        int totalWater = 0;
        for (int i = 0; i < height.length; i++){
            int currTrappedWatter = Math.min(left[i], right[i]) - height[i];
            if ( currTrappedWatter >= 0 ){
                totalWater += currTrappedWatter;
            } 
        }
        return totalWater;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int [] tc1Height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};  
        System.out.println(sol.trap(tc1Height));
    }
}