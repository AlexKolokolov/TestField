package org.kolokolov.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo2 {
    public static void main(String[] args) {
        Set<String> a = new HashSet<>();
        a.add("Alex");
        a.add("Bob");
        a.add("Harry");
        a.add("Kirk");
        
        Set<String> b = new HashSet<>();
        b.add("Mike");
        b.add("Alex");
        b.add("Ron");
        b.add("Harry");
        
        Set<String> retainResult = new HashSet<>(a);
        retainResult.retainAll(b);
        
        System.out.println(retainResult);
        
        Set<String> removeResult = new HashSet<>(a);
        removeResult.removeAll(b);
        
        System.out.println(removeResult);
       
    }
}
