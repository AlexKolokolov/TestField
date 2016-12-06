package org.kolokolov.steams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> sequance = Stream.iterate(10, n -> n - 1).limit(20).collect(Collectors.toList());
        System.out.println(sequance);
    }
}
