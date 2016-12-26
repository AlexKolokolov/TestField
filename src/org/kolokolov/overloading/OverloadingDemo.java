package org.kolokolov.overloading;

import java.util.Arrays;

public class OverloadingDemo {

    public static int sum(int...values) {
        return Arrays.stream(values).reduce(0, (a,b) -> a + b);
    }
    
    public static double sum(double...values) {
        return Arrays.stream(values).reduce(0, (a,b) -> a + b);
    }
    
    // next method is not allowed
//    public static int sum(double...values) {
//        return (int) Arrays.stream(values).reduce(0, (a,b) -> a + b);
//    }
}
