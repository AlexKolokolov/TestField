package org.kolokolov.collection;

import java.util.Arrays;
import java.util.Collections;

public class Sorting {
    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        
        System.out.print("Initial sequance: ");
        System.out.println(Arrays.toString(planets));
        
        Arrays.sort(planets);
        
        System.out.print("Sorted in dictionary order: ");
        System.out.println(Arrays.toString(planets));
        
        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.length(), p2.length()));
        
        System.out.print("Sorted by length: ");
        System.out.println(Arrays.toString(planets));   
        
        Collections.reverse(Arrays.asList(planets));
        
        System.out.print("In reverce order: ");
        System.out.println(Arrays.toString(planets));
        
        Arrays.stream(planets).map(String::toUpperCase).forEach(System.out::println);
    }
}
