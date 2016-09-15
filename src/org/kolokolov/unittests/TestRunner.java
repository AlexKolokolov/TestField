package org.kolokolov.unittests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJUnit.class);
        
        result.getFailures().stream().forEach(System.out::println);
        
        System.out.println(result.wasSuccessful());
    }
}
