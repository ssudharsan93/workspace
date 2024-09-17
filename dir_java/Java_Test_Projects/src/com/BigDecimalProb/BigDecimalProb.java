import java.math.*;
import java.util.*;
import java.math.BigDecimal;

public class BigDecimalProb {
	
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();
      	
        //Write your code here
      	//Java Bubble Sort
      	for ( int i = n; i > 0; i-- ) { 
      		for ( int j = 1; j < i; j++ ) {
      			BigDecimal curr_bd = new BigDecimal(s[j-1]);
      			BigDecimal next_bd = new BigDecimal(s[j]);
      			if ( curr_bd.compareTo(next_bd) < 0 ) { 
      				String tmp = s[j];
      				s[j] = s[j-1];
      				s[j-1] = tmp;
      			}
      		}
      	}

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}
