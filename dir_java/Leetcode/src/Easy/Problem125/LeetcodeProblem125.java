package src.Easy.Problem125;

import java.util.*;
import java.math.BigInteger;
import src.common.ListUtils;
import src.common.MathUtils;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        if ( s.length() == 0 ){
            return true;
        }

        int strLen = s.length();
        int mid = (int) Math.floor(s.length() / 2.0);

        for ( int strIdx = 0; strIdx <= mid; strIdx++ ){
            if ( s.charAt(strIdx) != s.charAt(strLen - 1 - strIdx) ){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args){ 
        Solution sol = new Solution();

        //tc1
        String tc1 = "A man, a plan, a canal: Panama";
        System.out.println(sol.isPalindrome(tc1));

        //tc2
        String tc2 = "race a car";
        System.out.println(sol.isPalindrome(tc2));

        //tc3
        String tc3 = " ";
        System.out.println(sol.isPalindrome(tc3));


    }
}