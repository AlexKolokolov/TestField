package org.kolokolov.collection;

import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        Integer[] arr = {10, 25, 15, 8, 10, 17, 20, 5};
        
        List<Integer> list = Arrays.asList(arr);
        
        System.out.println(list);
        
//        Unsupported operation
//        list.add(100);
        
        list.set(0, 1000);
        
        System.out.println(Arrays.toString(arr));
    }
}
