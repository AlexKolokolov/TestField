package org.kolokolov.io;

import java.io.File;
import java.util.Arrays;

public class DirecrtoryListDemo {
    public static void main(String[] args) {
        File file = new File("/home/kolokolov/Documents/TestPoligon");
        System.out.println(file.isDirectory());
        File[] files = file.listFiles((f) -> f.getName().endsWith(".txt"));
        Arrays.stream(files).map((f) -> f.getName() + " size: " + f.length()).sorted().forEach(System.out::println);
    }
}
