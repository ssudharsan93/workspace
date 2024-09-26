package src.Easy.Problem26;

class Solution {
    public static int removeDuplicates(int[] nums) {
        int p1 = 0; 
        int p2 = p1 + 1;
        while ( p2 < nums.length ){
            if ( nums[p1] != nums[p2] ){
                nums[p1 + 1] = nums[p2];
                p1 = p1 + 1;
            }
            p2 = p2 + 1;
        }

        return p1 + 1;
    }

    public static void main(String[] args){
        int [] nums = new int[]{1,1,2,3};
        int k = removeDuplicates(nums);

        System.out.print("[ ");
        for ( int i = 0; i < k; i++ ){
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

    }
}