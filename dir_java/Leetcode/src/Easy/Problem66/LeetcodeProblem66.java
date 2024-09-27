package src.Easy.Problem66;

import java.lang.*;
import java.util.*;

// Plus One
class Solution {
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int nextCarry = 0;
        ArrayList<Integer> digitsList = new ArrayList<>();
        for ( int digIdx = digits.length - 1; digIdx >= 0; digIdx-- ){
            if ( ( digits[digIdx] == 9 ) && ( carry == 1 ) ){
                digitsList.add(0, Integer.valueOf(0));
                nextCarry = 1;
                if ( digIdx == 0 ){ digitsList.add(0, Integer.valueOf(1)); }
            } else {
                digitsList.add(0, digits[digIdx] + carry);
                nextCarry = 0;
            }

            carry = nextCarry;
        }

        int[] res = new int[digitsList.size()];

        for ( int resIdx=0; resIdx < digitsList.size(); resIdx++ ){
            res[resIdx] = digitsList.get(resIdx).intValue();
        }

        return res;
    }

    public static void main(String[] args){
        //int[] result = plusOne(new int[]{9, 9, 9});
        int[] result = plusOne(new int[]{9, 8, 9});
        
        System.out.print("[ ");
        for ( int resIdx=0; resIdx < result.length; resIdx++ ){
            System.out.print(result[resIdx]);
            System.out.print(" ");
        }

        System.out.print(" ]");
    }
}