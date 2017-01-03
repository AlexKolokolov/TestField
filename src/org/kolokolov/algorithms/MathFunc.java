package org.kolokolov.algorithms;

import java.math.BigInteger;

public class MathFunc {
    
    public static void main(String[] args) {
        System.out.println(fact(1000));
    }
    
    public static BigInteger fact(int n) {
        if (n <= 1) return BigInteger.ONE;
        else return fact(n - 1).multiply(BigInteger.valueOf(n));
    }
}
