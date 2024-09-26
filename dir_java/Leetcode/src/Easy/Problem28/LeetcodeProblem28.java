package src.Easy.Problem28;

//Find the Index of the First Occurrence in a String

class Solution {
    public static int strStr(String haystack, String needle) {
        if ( needle.length() > haystack.length() ){ return -1; }
        for ( int hsIdx = 0; hsIdx < haystack.length(); hsIdx++ ){
            if ( haystack.charAt(hsIdx) == needle.charAt(0) ){
                if ( hsIdx + needle.length() > haystack.length() ){ return -1; }
                if ( haystack.substring(hsIdx, hsIdx + needle.length()).equals(needle) ){
                    return hsIdx;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        //System.out.println(strStr("leetcode", "leeto"));
        //System.out.println(strStr("sadbutsad", "sad"));
        //System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaa", "aaaa"));


    }
}