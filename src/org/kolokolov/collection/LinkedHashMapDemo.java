package org.kolokolov.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        
        @SuppressWarnings("serial")
        Map<String,Integer> map = new LinkedHashMap<String,Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String,Integer> eldest) {
                return size() > 5;
            }
        };
        
        map.put("Alex", 1);
        map.put("Bob", 2);
        map.put("Harry", 3);
        map.put("Hank", 4);
        map.put("Chris", 5);
        
        System.out.println(map);
        
        map.put("Nick", 6);
        
        System.out.println(map);
        
        
        Map<Integer,String> map2 = new LimitedLinkedHashMap<>();
        
        map2.put(1, "Alex");
        map2.put(2, "Bob");
        map2.put(3, "Harry");
        map2.put(4, "Hank");
        map2.put(5, "Chris");
        
        System.out.println(map2);
        
        map2.put(6, "Nick");
        
        System.out.println(map2);
    }
    
    @SuppressWarnings("serial")
    private static class LimitedLinkedHashMap<K,V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
            return size() > 5;
        }
    }
}
