package src.Problem20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> parenStack = new Stack<Character>();
        for ( int strIdx = 0; strIdx < s.length(); strIdx++ ){ 
            char curr = s.charAt(strIdx);
            if ( ( curr == '[') ||
                 ( curr == '(') ||
                 ( curr == '{') ) { 
                    parenStack.push(Character.valueOf(curr));
            }
            else if ( ( curr == ']') ||
                 ( curr == ')') ||
                 ( curr == '}') ) {
                    if ( parenStack.empty() ){
                        return false;
                    }
                    char topOfStack = parenStack.peek().charValue();
                    if ( compatibleChars(topOfStack, curr) ) { 
                        parenStack.pop();
                    } else { 
                        return false;
                    }
            }
        }

        if ( parenStack.empty() ){
            return true;
        }

        return false;
    }

    public static boolean compatibleChars(char c1, char c2){
        if ( c1 == c2 ) { 
            return false;
        }

        if ( ( ( c1 == '[' ) && ( c2 == ']' ) ) || 
                ( ( c1 == ']' ) && ( c2 == '[' ) ) ) {
                return true;
        }

        if ( ( ( c1 == '{' ) && ( c2 == '}' ) ) || 
                ( ( c1 == '}' ) && ( c2 == '{' ) ) ) {
                return true;
        }

        if ( ( ( c1 == '(' ) && ( c2 == ')' ) ) || 
                ( ( c1 == ')' ) && ( c2 == '(' ) ) ) {
                return true;
        }

        return false;
    }
}
