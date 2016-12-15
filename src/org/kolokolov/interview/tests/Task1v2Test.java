package org.kolokolov.interview.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kolokolov.interview.Task1v2;

@RunWith(Parameterized.class)
public class Task1v2Test {
    private String sourceString;
    private String expectedResultString;
    
    public Task1v2Test(String sourceString, String expectedResultString) {
        this.sourceString = sourceString;
        this.expectedResultString = expectedResultString;
    }
    
    @Parameters
    public static Collection<Object[]> strings() {
        return Arrays.asList(new Object[][]{
            {"6a2b2c", Task1v2.countLetters("aaabcaaabc")},
            {"1a2e1q3r1t1w", Task1v2.countLetters("aqweertrr")},
            {"3a1r2s3z", Task1v2.countLetters("zsszzraaa")}
        });
    }
    
    @Test
    public void testCountLetters() {
        Assert.assertEquals(expectedResultString, sourceString);
    }
}
