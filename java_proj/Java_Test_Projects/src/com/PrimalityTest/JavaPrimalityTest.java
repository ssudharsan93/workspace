import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JavaPrimalityTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger input_num = new BigInteger(n);
        if ( input_num.isProbablePrime(4) ) {
        	System.out.println("prime");
        } else {
        	System.out.println("not prime");
        }
        
        bufferedReader.close();
    }
    
    
}
