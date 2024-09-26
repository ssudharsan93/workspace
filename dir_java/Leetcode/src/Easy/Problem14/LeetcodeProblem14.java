package src.Easy.Problem14;

import java.lang.Math;

class Solution {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"reflower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {        
        if ( strs.length == 1 ) {
            return strs[0];
        }
        
        String currLongestSubstr = "";
        int currSubstrLen = 201;
        
        for ( int strIdx = 1; strIdx < strs.length; strIdx++ ){
            String curr = strs[strIdx - 1];
            String next = strs[strIdx];
            System.out.println(curr);
            System.out.println(next);
            currLongestSubstr = findLongestCommonStr(curr, next, currSubstrLen);

            currSubstrLen = currLongestSubstr.length();

            if ( currSubstrLen == 0 ){ 
                break;
            }

        }
            
        return currLongestSubstr;
    }
    
    public static String findLongestCommonStr(String str1, String str2, int currEndIdx){
        int endIdx = Math.min(str1.length(), str2.length());
        endIdx = Math.min(endIdx, currEndIdx);

        while ( endIdx != 0  ){ 
            if ( str1.substring(0, endIdx).equals( str2.substring(0, endIdx) ) ) { 
                return str1.substring(0, endIdx);
            }
            endIdx--;
        }

        return "";
    }
        
}