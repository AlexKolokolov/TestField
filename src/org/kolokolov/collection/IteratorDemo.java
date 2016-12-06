package org.kolokolov.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        
        strings.add("First");
        strings.add("Second");
        strings.add("Third");
        
        Iterator<String> iterator = strings.iterator();
        
        System.out.println(iterator.next());
        iterator.remove();
        
        System.out.println("==========================");
        
        strings.forEach(System.out::println);
        
        ListIterator<String> listIterator = strings.listIterator();
        listIterator.add("New First");
        
        System.out.println("==========================");
        
        strings.forEach(System.out::println);
        
        
    }
}
