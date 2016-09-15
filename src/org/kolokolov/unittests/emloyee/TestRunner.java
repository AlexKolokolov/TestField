package org.kolokolov.unittests.emloyee;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SimpleTestSuite.class, ParametrizedEmployeeTest.class);
        
        int totalTests = result.getRunCount();
        int failedTests = result.getFailureCount();
        if (failedTests > 0) {
            System.out.printf("%d tests out of %d were failed\n", failedTests, totalTests);
            result.getFailures().stream().forEach(System.out::println);
        }
        System.out.println("Result: " + result.wasSuccessful());
    }
}
