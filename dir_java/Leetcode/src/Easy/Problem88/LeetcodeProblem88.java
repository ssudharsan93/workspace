package src.Easy.Problem88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( m == 0 ){
            if ( n != 0 ){
                for ( int cpyIdx = 0; cpyIdx < n; cpyIdx++ ){
                    nums1[cpyIdx] = nums2[cpyIdx];
                }
            }
            else { return; }
        }

        if ( n == 0 ){
            return;
        }

        int [] result = new int[m + n];
        int mIdx = 0;
        int nIdx = 0;
        int mVal, nVal;

        while ( ( mIdx + nIdx ) < ( m + n ) ){
            if ( ( mIdx == m ) || ( nIdx == n ) ) { 
                
                if ( mIdx == m ){
                    result[mIdx + nIdx] = nums2[nIdx];
                    nIdx = nIdx + 1;
                }

                else if ( nIdx == n ){
                    result[mIdx + nIdx] = nums1[mIdx];
                    mIdx = mIdx + 1;
                }

            } else {

                mVal = nums1[mIdx];
                nVal = nums2[nIdx];
                
                if ( mVal <= nVal ){
                    result[mIdx + nIdx] = mVal;
                    mIdx = mIdx + 1;
                } else {
                    result[mIdx + nIdx] = nVal;
                    nIdx = nIdx + 1;
                }

            }

        }

        for ( int cpyIdx = 0; cpyIdx < ( m + n ); cpyIdx++ ){
            nums1[cpyIdx] = result[cpyIdx];
        }
    }

    public static void main(String[] args){
        //int [] nums1 = new int[]{1,2,3,0,0,0};
        //int [] nums2 = new int[]{2,5,6};
        //new Solution().merge(nums1, 3, nums2, 3);
        
        //int [] nums1 = new int[]{1};
        //int [] nums2 = new int[]{};
        //new Solution().merge(nums1, 1, nums2, 0);

        //int [] nums1 = new int[]{0};
        //int [] nums2 = new int[]{1};
        //new Solution().merge(nums1, 0, nums2, 1);

        //int [] nums1 = new int[]{4,5,6,0,0,0};
        //int [] nums2 = new int[]{1,2,3};
        //new Solution().merge(nums1, 3, nums2, 3);

        int [] nums1 = new int[]{4,0,0,0,0,0};
        int [] nums2 = new int[]{1,2,3,5,6};
        new Solution().merge(nums1, 1, nums2, 5);

        System.out.print("[ ");
        for ( int printIdx = 0; printIdx < nums1.length; printIdx++ ){
            System.out.print(nums1[printIdx]);
            System.out.print(" ");
        }
        System.out.println("]");
    }
}