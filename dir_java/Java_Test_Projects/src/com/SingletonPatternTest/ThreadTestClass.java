package src.com.SingletonPatternTest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ThreadTestClass implements Runnable {
    private int sleepTime = 0;

    public ThreadTestClass(int sleepTime){ 
        this.sleepTime = sleepTime;
    }

    public void run() {
        try { Thread.sleep(sleepTime * 1000); }
        catch ( Exception e ){ 
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        
        //SingletonPatternClass mySingleton = SingletonPatternClass.getSingletonInstance();
        SingletonPatternClass mySingleton = SingletonPatternClass.badGetSingletonInstance();
        if ( mySingleton == null  ){ 
            System.out.println("Instance is null");
        }
        System.out.println(mySingleton.toString());
    }

}