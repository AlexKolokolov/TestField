package org.kolokolov.lambdas;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        if (args.length > 0) {
            Arrays.asList(args).forEach(name -> System.out.println("Hello, " + name + "!"));
        } else {
            System.out.println("Hello, World!");
        }
    }
}
