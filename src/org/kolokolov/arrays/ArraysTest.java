package org.kolokolov.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class ArraysTest {
    public static void main(String[] args) {
        final int SIZE = 1000000;
        Random rnd = new Random();
        Integer[] initial = (Integer[]) Stream.generate(() -> rnd.nextInt(100)).limit(SIZE).toArray(size -> new Integer[SIZE]);
        
        Integer[] dest1 = new Integer[SIZE];
        Integer[] dest2 = new Integer[SIZE];
        Integer[] dest3 = new Integer[SIZE];
        
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            dest1[i] = initial[i];
        }
        long stop1 = System.currentTimeMillis();
        
        long start2 = System.currentTimeMillis();
        System.arraycopy(initial, 0, dest2, 0, SIZE);
        long stop2 = System.currentTimeMillis();
        
        long start3 = System.currentTimeMillis();
        dest3 = (Integer[]) Arrays.stream(initial).toArray(size -> new Integer[SIZE]);
        long stop3 = System.currentTimeMillis();
        
        System.out.println(stop1 - start1);
        System.out.println(stop2 - start2);
        System.out.println(stop3 - start3);
        
        
        Object[] arr = new  String[5];
        arr[0] = "string";
        System.out.println(arr[0]);
        // arr[1] = 1; // Causes the ArrayStoreException
    }
}
