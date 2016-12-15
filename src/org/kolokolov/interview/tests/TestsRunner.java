package org.kolokolov.interview.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestsRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Task1Test.class, Task1v2Test.class);
        
        result.getFailures().stream().forEach(System.out::println);
        
        System.out.println("Tests passed: " + result.wasSuccessful());
    }
}
