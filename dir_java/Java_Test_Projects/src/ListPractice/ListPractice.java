package com.ListPractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ListPractice {

    public static void main(String[] args)  throws IOException, NumberFormatException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(bufferedReader.readLine());
        String [] inputArrayNums = bufferedReader.readLine().split(" ");
        List<Integer> dataset = new ArrayList<Integer>();
        for ( int arrIdx = 0; arrIdx < arrSize; arrIdx++ ){
            dataset.add(Integer.decode(inputArrayNums[arrIdx]));
            System.out.println(dataset.get(arrIdx));
        }
        
        int numQueries = Integer.parseInt(bufferedReader.readLine());
        for ( int queryIdx = 0; queryIdx < numQueries; queryIdx++ ){
            String cmd = bufferedReader.readLine();
            
            if ( cmd.equals("Insert")){
                String [] insComArgs = bufferedReader.readLine().split(" ");
                int insertIdx = Integer.parseInt(insComArgs[0]);
                int elem = Integer.parseInt(insComArgs[1]);
                dataset.add(insertIdx, Integer.valueOf(elem));
            }
            else if ( cmd.equals("Delete") ){
                int deleteIdx = Integer.parseInt(bufferedReader.readLine());
                dataset.remove(deleteIdx);
            }
        }
        
        bufferedReader.close();
        
        int finalArrSize = dataset.size();
        for ( int finalArrIdx = 0; finalArrIdx < finalArrSize; finalArrIdx++ ){
            System.out.print(dataset.get(finalArrIdx));
            System.out.print(" ");
        }
        System.out.println("");
    }
}
