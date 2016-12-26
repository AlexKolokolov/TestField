package org.kolokolov.arrays;

import java.util.Arrays;

public class ArrayArguments {
    
    public static void main(String[] args) {
        System.out.println("1 + 2 + 3 = " + sum(1,2,3));
        System.out.println("10 + 20 + 30 = " + sum2(10,20,30));
    }

    static int sum(int...values) {
        int argc = values.length;
        int sum = 0;
        for (int i = 0; i < argc; i++) {
            sum += values[i];
        }
        return sum;
    }
    
    static int sum2(int...values) {
        return Arrays.stream(values).reduce(0, (a,b) -> a + b);
    }
}
