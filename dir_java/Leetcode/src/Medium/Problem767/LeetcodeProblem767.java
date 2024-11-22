package src.Medium.Problem767;

import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charCount = getCharCountMap(s);
        Set<Character> charsToProcess = charCount.keySet();
        List<Character> listDistinctChars = new ArrayList<>(charsToProcess);

        char [] reorganized = new char[s.length()];

        int arrIdx = 0;
        Character excludeChar = null;
        while ( ( !charsToProcess.isEmpty() ) && ( arrIdx < reorganized.length ) ) {
            Character currChar = getNextMostCommonChar(charCount, excludeChar);

            // System.out.println(charCount);
            // System.out.println(charsToProcess);
            
            if ( charsToProcess.contains(currChar) ){ 
                int remainingCharCount = charCount.get(currChar).intValue();
                
                if ( ( charsToProcess.size() == 1 ) &&  ( remainingCharCount > 1 ) ) { 
                    return "";
                }

                reorganized[arrIdx] = currChar.charValue();
                excludeChar = currChar;

                remainingCharCount = remainingCharCount - 1;
                charCount.put(
                    currChar,
                    Integer.valueOf(remainingCharCount)
                );

                if ( remainingCharCount == 0 ){
                    charsToProcess.remove(currChar);
                }

                arrIdx = arrIdx + 1;
            }

            //System.out.println(new String(reorganized));

        }

        return new String(reorganized);
    }

    public Character getNextMostCommonChar(Map<Character, Integer> charCountMap, Character excludeChar) {
        Set<Character> distinctChars = charCountMap.keySet();

        Character commonChar = null;
        int maxCount = 0;
        for ( Character distinctChar : distinctChars ){
            if ( excludeChar != null ){
                if ( distinctChar.equals(excludeChar) ) { 
                        continue;
                }
            }

            int currCharCount = charCountMap.get(distinctChar).intValue();

            if ( ( currCharCount > maxCount ) ){
                maxCount = currCharCount;
                commonChar = distinctChar;
            }
        }

        return commonChar;


    }
    public Map<Character, Integer> getCharCountMap(String input){
        Map<Character, Integer> myMap = new HashMap<Character, Integer>();
        for ( int strIdx = 0; strIdx < input.length(); strIdx++ ){
            char currChar = input.charAt(strIdx);
            if ( myMap.getOrDefault(Character.valueOf(currChar), null ) == null ) {
                myMap.put(Character.valueOf(currChar), Integer.valueOf(1));
            } else {
                int currCharCount = myMap.get(Character.valueOf(currChar)).intValue();
                myMap.put(
                    Character.valueOf(currChar),
                    Integer.valueOf(currCharCount + 1)
                );
            }
        }

        return myMap;
    }
    

    public static void main(String[] args){ 
        Solution sol = new Solution();

        String tc = "aab";
        String res = sol.reorganizeString(tc);
        System.out.println("Original: " + tc);
        System.out.println("Result: " + res);

        String tc2 = "aaab";
        String res2 = sol.reorganizeString(tc2);
        System.out.println("Original: " + tc2);
        System.out.println("Result: " + res2);

        String tc3 = "baaba";
        String res3 = sol.reorganizeString(tc3);
        System.out.println("Original: " + tc3);
        System.out.println("Result: " + res3);

        String tc4 = "vvvlo";
        String res4 = sol.reorganizeString(tc4);
        System.out.println("Original: " + tc4);
        System.out.println("Result: " + res4);

        String tc5 = "aaabbccd";
        String res5 = sol.reorganizeString(tc5);
        System.out.println("Original: " + tc5);
        System.out.println("Result: " + res5);
    }
}