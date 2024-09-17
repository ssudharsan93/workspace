import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BitSetPractice {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner dataScanner = new Scanner(System.in);
        int lenBitSet = dataScanner.nextInt();
        int numCMDs = dataScanner.nextInt();
        BitSet b1 = new BitSet(lenBitSet);
        BitSet b2 = new BitSet(lenBitSet);
        String cmd;
        int leftOperand;
        int rightOperand;
        
        for ( int cmdItr = 0; cmdItr < numCMDs; cmdItr++ ) {
            dataScanner.nextLine();
            cmd = dataScanner.next();
            leftOperand = dataScanner.nextInt();
            rightOperand = dataScanner.nextInt();
            
            System.out.println(cmd);
            System.out.println(leftOperand);
            System.out.println(rightOperand);
            
            //System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        
        dataScanner.close();
    }
}