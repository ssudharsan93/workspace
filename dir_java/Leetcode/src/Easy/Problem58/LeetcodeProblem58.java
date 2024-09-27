package src.Easy.Problem58;

//Length of Last Word
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\s");
        return words[words.length - 1].length();
    }
}