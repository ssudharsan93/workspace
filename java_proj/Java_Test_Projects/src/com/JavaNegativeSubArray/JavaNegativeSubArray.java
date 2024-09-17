import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JavaNegativeSubArray {

    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	int arrSize = Integer.parseInt(bufferedReader.readLine());
    	int intArr[] = new int[arrSize];
    	String [] inputArrayNums = bufferedReader.readLine().split(" ");
    	    	
    	for ( int i = 0; i < arrSize; i++ ) { 
    		intArr[i] = Integer.parseInt(inputArrayNums[i]);
    	}
    	
    	int numNegativeSubArrays = 0;
    	int sum;
 
    	for ( int i = 0; i < arrSize; i++ ) {
    		sum = 0;
    		for (int j = i; j < arrSize; j++ ) {
    			if ( j == i ) {
    				sum = intArr[i];
    			} else { 
    				sum = sum + intArr[j];
    			}
    			
    			if ( sum < 0 ) { numNegativeSubArrays++; }
    		}
    	}
    	
    	System.out.println(numNegativeSubArrays);
    }
}
