package org.kolokolov.hadoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Mapper {
    public static void main(String[] args) {
        try (Stream<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines()) {
            lines.flatMap(l -> Stream.of(l.split(" "))).forEach(w -> System.out.println(w + "\t1"));
        } 
    }
}
