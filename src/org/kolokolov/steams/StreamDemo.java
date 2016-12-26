package org.kolokolov.steams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> sequance = Stream.iterate(10, n -> n - 1).limit(20).collect(Collectors.toList());
        System.out.println(sequance);
        
        int sum2 = IntStream.iterate(1, x -> x + 1).parallel().limit(100).peek(x -> {
            System.out.println(Thread.currentThread().getId());
        }).sum();
        System.out.println(sum2);
        
        String str = "asd dfg hjk";
        Stream.of(str.split(" ")).forEach(System.out::println);
        
        String[] strings = {"zxc", "vbn", "m,."};
        Stream.of(strings).forEach(System.out::println);
        
        printStrings("qwe", "rty", "uio");
        
        System.out.println("1 + 2 + 3 = " + sumInts(1,2,3));
    }
    
    public static void printStrings(String...strings) {
        Stream.of(strings).forEach(System.out::println);
    }
    
    public static int sumInts(int...values) {
        return IntStream.of(values).sum();
    }
}
