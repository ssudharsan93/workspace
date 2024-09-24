import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

	public static void main(String[] args) {
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(-2, -1, 0, 1,2));
		plusMinus(inputArray);
	}
	
	 public static void plusMinus(List<Integer> arr) {
	        int sizeOfArr = arr.size();
	        
	        int positives = 0;
	        int negatives = 0;
	        int zeros = 0;
	        
	        for ( int i = 0; i < sizeOfArr; i++ ) { 
	        	int elem = arr.get(i).intValue();
	        	if ( elem > 0 ) { positives++; }
	        	else if ( elem < 0 ) { negatives++; }
	        	else { zeros++; } 
	        }
	        
	        double positives_proportion = ( positives * 1.0 ) / ( sizeOfArr * 1.0 );
	        double negatives_proportion = ( negatives * 1.0 ) / ( sizeOfArr * 1.0 );
	        double zeros_proportion = ( zeros * 1.0 ) / ( sizeOfArr * 1.0 );

	        
	        System.out.printf("%.6f\n", positives_proportion);
	        System.out.printf("%.6f\n", negatives_proportion);
	        System.out.printf("%.6f\n", zeros_proportion);
	        
	 }
}
