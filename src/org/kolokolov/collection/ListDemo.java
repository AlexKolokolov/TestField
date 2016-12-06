package org.kolokolov.collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> ints = IntStream.range(1, 50).boxed().collect(Collectors.toList());
        
        System.out.println(ints);
        Collections.shuffle(ints);
        
        System.out.println(ints);
    }
}
