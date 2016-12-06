package org.kolokolov.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        Set<Item> sortedItems = new TreeSet<>();
        sortedItems.add(new Item("Toaster", 123));
        sortedItems.add(new Item("Lamp", 10));
        sortedItems.add(new Item("Computer", 5013));
        sortedItems.add(new Item("Car", 5013));
        sortedItems.add(new Item("Toaster", 123));
        
        System.out.println(sortedItems);
        
        Set<Item> comparedItems = new TreeSet<>(Comparator.comparing(Item::getDescription));
        
        comparedItems.addAll(sortedItems);
        
        System.out.println(comparedItems);
    }
}

class Item implements Comparable<Item> {
    
    private String description;
    private int partNumber;
    
    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(this.partNumber, o.partNumber);
        return diff != 0 ? diff : this.description.compareTo(o.description);
    }
    
    @Override
    public String toString() {
        return "Item {" + this.description + ", " + partNumber + " parts}";
    }
}