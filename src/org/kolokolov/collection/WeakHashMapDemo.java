package org.kolokolov.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> weakHashMap = new WeakHashMap<>();
        
        String alex = "Alex";
        String bob = "Bob";
        String harry = "Harry";
        
        weakHashMap.put(alex, 1);
        weakHashMap.put(bob, 2);
        weakHashMap.put(harry, 3);
        
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put(alex, 11);
        hashMap.put(bob, 12);
        hashMap.put(harry, 13);
        
        alex = null;
        
        System.out.println(weakHashMap.get(alex));
        System.out.println(weakHashMap.get(bob));
        
        System.gc();
        
        weakHashMap.entrySet().forEach(System.out::println);
        
        System.out.println(weakHashMap.get(alex));
        System.out.println(weakHashMap.get(bob));
        
        System.out.println(hashMap.get(alex));
        System.out.println(hashMap.get(bob));
        
    }
}
