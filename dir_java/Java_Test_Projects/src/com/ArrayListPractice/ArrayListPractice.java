package src.com.ArrayListPractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayListPractice {

	public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        List<List<Integer>> dataArrList = new ArrayList<>();
	        String errString = "ERROR!";
	        Scanner scanner = new Scanner(System.in);
	        int numArrLists = scanner.nextInt();
	        
	        for ( int arrItr = 0; arrItr < numArrLists; arrItr++ ){
	            List<Integer> currArr = new ArrayList<Integer>();
	            int currNumElements = scanner.nextInt();

	            for ( int elemItr = 0; elemItr < currNumElements; elemItr++ ){
	                int currElem = scanner.nextInt();
	                currArr.add(Integer.valueOf(currElem));
	            }
	            dataArrList.add(currArr);
	        }
	        
	        int numQueries = scanner.nextInt();
	        List<List<Integer>> queryArr = new ArrayList<>();
	        	        
	        for ( int queryItr = 0; queryItr < numQueries; queryItr++ ){
	            List<Integer> currQuery = new ArrayList<Integer>();
	            int arrIdx = scanner.nextInt() - 1;
	            currQuery.add(Integer.valueOf(arrIdx));
	            int elemIdx = scanner.nextInt() - 1;
	            currQuery.add(Integer.valueOf(elemIdx));
	            
	            queryArr.add(currQuery);
	        }
	        
	        scanner.close();

	        
	        for ( int respItr = 0; respItr < numQueries; respItr++ ){
	        	List<Integer> currQuery = queryArr.get(respItr);
	        	int queryArrIdx = currQuery.get(0);
	        	int queryElemIdx = currQuery.get(1);
	        	
	        	if ( queryArrIdx >= numArrLists ){
	                System.out.println(errString);
	            } else { 
	                List<Integer> currDataArr = dataArrList.get(queryArrIdx);
	                if ( queryElemIdx >= currDataArr.size() ) {
	                    System.out.println(errString);
	                }
	                else { 
	                    System.out.println(currDataArr.get(queryElemIdx));
	                }
	            }
	        }
	}

}
