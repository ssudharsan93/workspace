package src.Easy.Problem67;

import java.lang.*;
import java.util.*;

// Add Binary

class Solution {
    public static String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        char bitA, bitB;
        char carryBit = '0';
        char resultBit;
        StringBuilder res = new StringBuilder();

        for ( int bitIdx = 0; bitIdx < maxLen; bitIdx++ ){
            bitA = getBit(a, bitIdx);
            bitB = getBit(b, bitIdx);

            //System.out.print(bitA);
            //System.out.print(" + ");
            //System.out.print(bitB);
            //System.out.print(" + ");
            //System.out.print(carryBit);
            //System.out.print(" = ");

            resultBit = getResultBit(getSum(bitA, bitB, carryBit));
            carryBit = getCarryBit(getSum(bitA, bitB, carryBit));

            //System.out.print(resultBit);
            //System.out.print(" , ");
            //System.out.println(carryBit);

            res.insert(0, resultBit);

            if ( ( bitIdx == maxLen - 1 ) && carryBit == '1'){
                res.insert(0, '1');
            }
        }

        return res.toString();
    }

    public static char getBit(String curr, int bitIdx){ 
        if ( bitIdx > curr.length() - 1 ){ return '0'; }
        else { return curr.charAt(curr.length() - 1 - bitIdx); }
    }

    public static char getResultBit(int sum){
        switch(sum){
            case 0: return '0';
            case 1: return '1';
            case 2: return '0';
            case 3: return '1';
            default: return '0';
        }
    }

    public static char getCarryBit(int sum){
        switch(sum){
            case 0: return '0';
            case 1: return '0';
            case 2: return '1';
            case 3: return '1';
            default: return '0';
        }
    }

    public static int getSum(char b1, char b2, char carry){ 
        int b1Int = b1 - '0';
        int b2Int = b2 - '0';
        int carryInt = carry - '0';

        return b1Int + b2Int + carryInt;
    }

    public static void main(String[] args){
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}