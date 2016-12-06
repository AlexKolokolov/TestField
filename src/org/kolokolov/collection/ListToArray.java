package org.kolokolov.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Alex");
        strings.add("Bob");
        strings.add("Harry");
        
        System.out.println(strings);
        
        // creating a new array
        String[] array = strings.toArray(new String[0]);
        
        Arrays.stream(array).forEach(System.out::println);
        
        // filling an array passed as a parameter
        String[] array2 = new String[strings.size()];
        
        strings.toArray(array2);
        
        Arrays.stream(array2).forEach(System.out::println);
        
        // filling an array with bigger size passed as a parameter
        String[] array3 = new String[10];
        
        strings.toArray(array3);
        
        Arrays.stream(array3).forEach(System.out::println); // rest of array filled with nulls
        
        // trying to fill array smaller than list. Effort failed!
        String[] array4 = new String[2];
        
        strings.toArray(array4);
        
        Arrays.stream(array4).forEach(System.out::println);
        
    }
}
