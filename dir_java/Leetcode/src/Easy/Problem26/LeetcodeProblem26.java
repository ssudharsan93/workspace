class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0; 
        int p2 = p1 + 1;
        int numUniqElems = 1;
        int searchVal = nums[p1];
        while ( p2 < nums.length ){
            if ( searchVal == nums[p2] ){
                System.out.println(nums[p1]);
                System.out.println(nums[p2]);
                while( ( p2 < nums.length ) && ( searchVal == nums[p2] ) ){
                   p2 = p2 + 1;
                }
                if ( p2 == nums.length ) { return numUniqElems; }
                searchVal = nums[p2];
                nums[p1 + 1] = searchVal;
            }

            numUniqElems = numUniqElems + 1;
            p1 = p1 + 1;
            p2 = p2 + 1;
        }

        return numUniqElems;
    }

    public static void main(String[] args){
        removeDuplicates(new int[]{1, 2, 2});
    }
}