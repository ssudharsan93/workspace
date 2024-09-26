package src.Easy.Problem9;

//Palindrome Number

import java.lang.*;
import java.lang.StringBuilder;

class Solution {
    public boolean isPalindrome(int x) {
        String integerRep = Integer.toString(x);
        String reversedString = null;

        StringBuilder sb = new StringBuilder();

        for ( int strIdx = integerRep.length() - 1; strIdx >= 0; strIdx-- ){
            sb.append(integerRep.charAt(strIdx));
        }

        return integerRep.equals(sb.toString());
    }
}