package src.common;

import java.util.*;
import java.math.*;

public class MathUtils {
    public static int nCr(int n, int k){
        return MathUtils.factorial(n).divide(MathUtils.factorial(n - k).multiply(MathUtils.factorial(k))).intValue();
    }

    public static BigInteger factorial(int num){
        BigInteger result = BigInteger.valueOf((long) 1);
        while ( num > 0 ){
            result = result.multiply(BigInteger.valueOf(((long) num)));
            num = num - 1;
        }

        return result;
    }
}