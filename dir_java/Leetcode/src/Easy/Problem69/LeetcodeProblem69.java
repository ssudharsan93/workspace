package src.Easy.Problem69;

import java.lang.*;
import java.util.*;

// Add Binary

class Solution {
    public static int mySqrt(int x) {
        //double sqrtOfX = numericalTechniqueSqrt(x);
        //System.out.print("Float estimate of sqrt of x : ");
        //System.out.println(sqrtOfX);
        //return (int) Math.floor(sqrtOfX);

        return altMethodClosestSqrtInt(x);
    }

    public static int altMethodClosestSqrtInt(int numToSqrt){
        int sqrtIdx;

        if ( numToSqrt == 0 ){
            return 0;
        } else if ( numToSqrt == 1 ){
            return 1;
        }

        long numToCompare = (long) numToSqrt;
        long curr;

        for ( sqrtIdx = 0; sqrtIdx < numToSqrt; sqrtIdx++ ){
            curr = (long) sqrtIdx * (long) sqrtIdx;
            if ( curr > numToCompare ){
                break;
            }
            else if ( ( sqrtIdx * sqrtIdx ) == numToSqrt ){ return sqrtIdx; }
        }

        return ( sqrtIdx - 1 );
    }

    public static double numericalTechniqueSqrt(int numToSqrt){
        double estimate = numToSqrt / 2.0;

        for ( int sqrtIdx = 0; sqrtIdx < 100; sqrtIdx++ ){
            estimate = 0.5 * ( ( numToSqrt / estimate ) + estimate );
        }

        return estimate;
    }
    
    public static void main(String[] args){
        //System.out.println(mySqrt(625));
        //System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147483646));
    }
}