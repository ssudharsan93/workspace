package src.Easy.Problem27;

//Remove Element

class Solution {
    public static int removeElement(int[] nums, int val) {
        int p1 = 0; 
        int p2 = p1 + 1;
        int tmp;

        while ( p2 < nums.length || p1 < nums.length ){
            if ( nums[p1] == val ){ // Checks if val needs to be pushed right.
                if ( p2  < nums.length ) {
                    if ( nums[p1] != nums[p2] ){
                        tmp = nums[p2];
                        nums[p2] = nums[p1];
                        nums[p1] = tmp;
                        p1 = p1 + 1;
                    }
                } else { return p1; }
                // if p2 has already finished p1 has likely 
                // found the first 'val' Value that was pushed right.
            } else { // Non 'val' values haven't all been found so keep moving p1 to the right.
                p1 = p1 + 1;
            }

            p2 = p2 + 1;
        }

        return p1;
    }

    public static void main(String[] args){
        //int [] nums = new int[]{1,1,2,3};
        //int [] nums = new int[]{3,2,2,3};
        int [] nums = new int[]{2};
        //int [] nums = new int[]{3,3};
        
        
        int k = removeElement(nums, 5);

        System.out.print("[ ");
        for ( int i = 0; i < k; i++ ){
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

    }
}