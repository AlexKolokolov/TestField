package org.kolokolov.serialization.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SerializerTest.class);
        
        result.getFailures().stream().forEach(System.out::println);
        
        System.out.println("Tests passed: " + result.wasSuccessful());
    }
}
