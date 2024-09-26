package src.Easy.Problem13;

//Roman to Integer

class Solution {
    public int romanToInt(String s) {
        int strLen = s.length();
        int intRep = 0;

        for ( int strIdx = 0; strIdx < strLen; strIdx++ ){
            char currentChar = s.charAt(strIdx);
            int exceptionResolved = 0;

            if ( ( currentChar == 'I' ) ||
                 ( currentChar == 'X' ) ||
                 ( currentChar == 'C' ) ) {
                if( strIdx + 1 < strLen ){
                    exceptionResolved = exception(s.substring(strIdx, strIdx + 2 ));
                    if ( exceptionResolved != 0 ){ 
                        intRep = intRep + exceptionResolved;
                        strIdx = strIdx + 1;
                        continue;
                    }
                }

            }

            intRep = intRep + mapping(currentChar);

        }

        return intRep;
    }

    public int mapping(char c){
        switch(c) {
            case 'I': 
                return 1;
            case 'V': 
                return 5;
            case 'X': 
                return 10;
            case 'L': 
                return 50;
            case 'C': 
                return 100;
            case 'D': 
                return 500;
            case 'M': 
                return 1000;
            default: return 0;
        }
    }

    public int exception(String s){
        switch(s) {
            case "IV": 
                return 4;
            case "IX": 
                return 9;
            case "XL": 
                return 40;
            case "XC": 
                return 90;
            case "CD": 
                return 400;
            case "CM": 
                return 900;
            default: return 0;
        }
    }
}