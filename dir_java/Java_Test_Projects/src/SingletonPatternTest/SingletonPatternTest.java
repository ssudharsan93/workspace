package src.com.SingletonPatternTest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SingletonPatternTest {

	public static void main(String[] args) {
		ThreadTestClass threadObj1 = new ThreadTestClass(1);
		ThreadTestClass threadObj2 = new ThreadTestClass(1);

		Thread thread1 = new Thread(threadObj1);
		Thread thread2 = new Thread(threadObj2);

		thread1.start();
		thread2.start();

	}

}
