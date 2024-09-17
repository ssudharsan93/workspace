import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BigIntegerProb {

	public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a first number:");
            BigInteger firstNum = new BigInteger(br.readLine());
            System.out.println("Enter a second number:");
            BigInteger secondNum = new BigInteger(br.readLine());
            BigInteger added = firstNum.add(secondNum);
            BigInteger multiplied = firstNum.multiply(secondNum);
            
            System.out.println(added.toString());
            System.out.println(multiplied.toString());
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
	}

}
