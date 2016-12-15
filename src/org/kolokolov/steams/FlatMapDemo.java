package org.kolokolov.steams;

import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        
        Stream.of(planets).flatMap(p -> p.codePoints().mapToObj(cp -> (char) cp)).forEach(System.out::print);
    }
}
