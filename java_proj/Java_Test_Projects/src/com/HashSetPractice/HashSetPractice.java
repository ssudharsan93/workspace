package com.HashSetPractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HashSetPractice {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        
        s.close();

        Set<List<String>> nameSet = new HashSet<>();
        for (int i = 0; i < t; i++) {
            String leftElem = pair_left[i];
            String rightElem = pair_right[i];
            ArrayList<String> newNamePair = new ArrayList<String>(Arrays.asList(leftElem, rightElem));
            nameSet.add(newNamePair);
            System.out.println(nameSet.size());
        }

    }
}
