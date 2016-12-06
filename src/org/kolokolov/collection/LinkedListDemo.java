package org.kolokolov.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> men = new LinkedList<>();
        men.add("Alex");
        men.add("Bob");
        men.add("Dick");
        men.add("Harry");
        men.add("Mike");
        
        List<String> women = new LinkedList<>();
        women.add("Alice");
        women.add("Nancy");
        women.add("Gloria");
        women.add("Marry");
        women.add("Rebecca");
        women.add("Holly");
        
        System.out.println(mergeLists(men, women));
    }
    
    public static List<String> mergeLists(List<String> one, List<String> two) {
        Iterator<String> oneIter = one.iterator();
        Iterator<String> twoIter = two.iterator();
        
        List<String> result = new LinkedList<>();
        
        while(oneIter.hasNext() || twoIter.hasNext()) {
            if (oneIter.hasNext()) result.add(oneIter.next());
            if (twoIter.hasNext()) result.add(twoIter.next());
        }
        
        return result;
    }
}
