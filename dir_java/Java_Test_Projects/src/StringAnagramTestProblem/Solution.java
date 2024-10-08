package src.StringAnagramTestProblem;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean checkForAnagrams(String s1, String s2) {

        String[] s1Words = s1.split("\\s+");
        String[] s2Words = s2.split("\\s+");

        if ( s1Words.length != s2Words.length ){ return false; }

        List<HashMap<Character, Integer>> charCountsS1 = Solution.getCountHashMapsForArray(s1Words);
        List<HashMap<Character, Integer>> charCountsS2 = Solution.getCountHashMapsForArray(s2Words);

        Solution.printSpaceSeparatedStrings(s1Words);
        Solution.printSpaceSeparatedStrings(s2Words);

        int s1WordIdx = 0;
        int s2WordIdx = 0;
        while (  s2WordIdx < s2Words.length && s1WordIdx < s1Words.length ){
                String s1Word = s1Words[s1WordIdx];
                String s2Word = s2Words[s2WordIdx];

                if ( s1Word.length() != s2Word.length() ){
                    s1WordIdx = s1WordIdx + 1;
                    if ( s1WordIdx == s1Words.length ){
                        return false;
                    }
                    continue;
                }

                // Gets the distinct characters in a word for example word parrot contains 'p', 'a', 'r', 'o', 't'
                Character[] distinctChars =  Solution.getDistinctCharsForString(s2Word);

                for ( Character currChar : distinctChars ){
                    Integer char1Count = charCountsS1.get(s1WordIdx).getOrDefault(currChar, null);
                    Integer char2Count = charCountsS2.get(s2WordIdx).getOrDefault(currChar, null);
                    if ( ( char1Count == null ) || ( char1Count != char2Count ) ){
                        s1WordIdx = s1WordIdx + 1;
                        if ( s1WordIdx == s1Words.length ){
                            return false;
                        }
                        continue;
                    }
                }

                s2WordIdx = s2WordIdx + 1;
                s1WordIdx = 0;
        }

        return true;
    }

    public static Character[] getDistinctCharsForString(String inputStr){
        HashSet<Character> charSet = new HashSet<>();

        for ( int strIdx = 0; strIdx < inputStr.length(); strIdx++ ){
            Character currChar = Character.valueOf(inputStr.charAt(strIdx));
            charSet.add(currChar);
        }

        return charSet.toArray(new Character[0]);
    }

    public static List<HashMap<Character, Integer>> getCountHashMapsForArray(String[] words){
        List<HashMap<Character, Integer>> charCounts = new ArrayList<>();
        for ( int wordIdx = 0; wordIdx < words.length; wordIdx++ ){
            charCounts.add(getCountHashMapForWord(words[wordIdx]));
        }
        return charCounts;
    }

    public static HashMap<Character,Integer> getCountHashMapForWord(String inputStr){
        HashMap<Character, Integer> countMap = new HashMap<>();

        for ( int strIdx = 0; strIdx < inputStr.length(); strIdx++ ){
            Character currChar = Character.valueOf(inputStr.charAt(strIdx));
            if ( countMap.getOrDefault(currChar, null) == null ){
                countMap.put(currChar, Integer.valueOf(1));
            } else {
                Integer incremented = Integer.valueOf(countMap.get(currChar).intValue() + 1);
                countMap.put(currChar, incremented); 
            }
        }

        return countMap;
    }

    public static void printSpaceSeparatedStrings(String[] strArr){
        for ( int strIdx = 0; strIdx < strArr.length; strIdx++ ){
            System.out.print(strArr[strIdx]);
            System.out.print(" ");
        }

        System.out.println("");
    }

    public static void main(String[] args){
        // Testcase1
        String s1 = "raptor cat";
        String s2 = "act parrot";
        System.out.println(Solution.checkForAnagrams(s1, s2));

        // Testcase2
        // String s1 = "reaper cat";
        // String s2 = "act parrot";
        // System.out.println(Solution.checkForAnagrams(s1, s2));
    }
}