package src.com.SingletonPatternTest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SingletonPatternClass {
	private static SingletonPatternClass mainInst = null;
	private static String flag = "FLAG";
	
	private SingletonPatternClass() {
		return;
	}

	public static SingletonPatternClass getSingletonInstance() {
		System.out.println("Trying to get the only Singleton Instance.");
		if ( mainInst == null ){ 
			synchronized(flag) {
				if ( mainInst == null ) {
					System.out.println("There isn't a Singleton Instance yet!");
					System.out.println("Creating a Singleton Instance...");
					mainInst = new SingletonPatternClass();
					System.out.println("Singleton Instance Created.");
				}
			}
		}

		return mainInst;
	}

	public static SingletonPatternClass badGetSingletonInstance() {
		System.out.println("Trying to get the only Singleton Instance.");
		if ( mainInst == null ){ 
			synchronized(flag) {
					System.out.println("There isn't a Singleton Instance yet!");
					System.out.println("Creating a Singleton Instance...");
					mainInst = new SingletonPatternClass();
					System.out.println("Singleton Instance Created.");
			}
		}

		return mainInst;
	}
}
