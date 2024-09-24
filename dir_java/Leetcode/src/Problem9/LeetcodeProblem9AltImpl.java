import java.lang.*;
import java.lang.StringBuilder;

class Solution {
    public boolean isPalindrome(int x) {
        String integerRep = Integer.toString(x);
        int endIdx = (int) Math.floor( integerRep.length() / 2.0 );
        
        for ( int strIdx = 0; strIdx <= endIdx; strIdx++ ){
            if ( integerRep.charAt(strIdx) != integerRep.charAt(integerRep.length() - 1 - strIdx) ){ 
                return false;
            }
        }

        return true;
    }
}