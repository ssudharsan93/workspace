package src.Easy.Problem35;

//Search Insert Position

class Solution {
    public static int searchInsert(int[] nums, int target) {
        int endIdx = nums.length - 1;
        int startIdx = 0;
        int midpoint = (int) Math.floor(( endIdx + startIdx ) / 2.0);

        int targIdx = -1;

        while ( endIdx >= startIdx ){
            midpoint = (int) Math.floor(( endIdx + startIdx ) / 2.0);
            if ( (endIdx - startIdx) < 2 ){
                if ( target < nums[startIdx] ){
                    targIdx = startIdx;
                } else if ( target > nums[endIdx] ){
                    targIdx = endIdx + 1;
                } else {
                    if ( target == nums[startIdx] ){ targIdx = startIdx; } 
                    else if ( target == nums[endIdx] ) { targIdx = endIdx; } 
                    else { targIdx = startIdx + 1; }
                }
                break;
            }

            if ( target < nums[midpoint] ){
                endIdx = midpoint - 1;
            } else if ( target > nums[midpoint] ){
                startIdx = midpoint + 1;
            } else { 
                return midpoint;
            }
        }

        return targIdx;
    }

    public static void main(String[] args){
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5}, 4));
    }
}