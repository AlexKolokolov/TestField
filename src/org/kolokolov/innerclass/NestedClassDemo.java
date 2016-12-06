package org.kolokolov.innerclass;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NestedClassDemo {
    
    public static void main(String[] args) {
        Random rnd = new Random();
        Set<Integer> list = Stream.generate(() -> rnd.nextInt(100)).limit(20).collect(Collectors.toSet());
        System.out.println(list);
        
        Pair<Integer> result = getMinAndMax(list);
        
        System.out.println("min = " + result.getFirst());
        System.out.println("max = " + result.getSecond());
        
        String[] strings = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        List<String> stringList = Arrays.asList(strings);
        
        System.out.println(stringList);
        
        Pair<String> strResult = getMinAndMax(stringList, Comparator.comparing(String::length));
        
        System.out.println("shortest: " + strResult.getFirst());
        System.out.println("longest: " + strResult.getSecond());
        
        Pair<String> dicResult = getMinAndMax(stringList);
        
        System.out.println("first: " + dicResult.getFirst());
        System.out.println("last: " + dicResult.getSecond());
    }
    
    
    public static <T extends Comparable<T>> Pair<T> getMinAndMax(Collection<T> collection) {
        Iterator<T> iter = collection.iterator();
        T min = null, max = null;
        if (iter.hasNext()) min = max = iter.next();
        while(iter.hasNext()) {
            T next = iter.next();
            if (next.compareTo(min) < 0) min = next;
            if (next.compareTo(max) > 0) max = next;
        }
        return new Pair<T>(min, max);
    }
    
    public static <T> Pair<T> getMinAndMax(Collection<T> collection, Comparator<T> comparator) {
        Iterator<T> iter = collection.iterator();
        T min = null, max = null;
        if (iter.hasNext()) min = max = iter.next();
        while(iter.hasNext()) {
            T next = iter.next();
            if (comparator.compare(next, min) < 0) min = next;
            if (comparator.compare(next, min) > 0) max = next;
        }
        return new Pair<T>(min, max);
    }
    
    
    private static class Pair<T> {
        private T first;
        private T second;
        
        
        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
        
        public T getFirst() {
            return this.first;
        }
        
        public T getSecond() {
            return this.second;
        }
    }
}
