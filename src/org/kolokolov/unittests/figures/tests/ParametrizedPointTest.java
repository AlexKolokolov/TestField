package org.kolokolov.unittests.figures.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kolokolov.unittests.figures.Point;

@RunWith(Parameterized.class)
public class ParametrizedPointTest {

    private Point testPoint1;
    private Point testPoint2;
    private Point testPoint3;
    private boolean expectedResult;
    
    public ParametrizedPointTest(Point testPoint1, Point testPoint2, Point testPoint3, boolean expectedResult) {
        super();
        this.testPoint1 = testPoint1;
        this.testPoint2 = testPoint2;
        this.testPoint3 = testPoint3;
        this.expectedResult = expectedResult;
    }
    
    @BeforeClass
    public static void init() {
        System.out.println("Parametrized point test started");
    }
    
    @AfterClass
    public static void finish() {
        System.out.println("Parametrized point test completed");
    }
    
    @Parameters
    public static Collection<Object[]> points() {
        return Arrays.asList(new Object[][] {
            {new Point(0,0), new Point(3,4), new Point(6,8), true},
            {new Point(0,0), new Point(5,5), new Point(10,9), false},
            {new Point(5,5), new Point(1,1), new Point(5,5), true},
            {new Point(5,5), new Point(10,10), new Point(0,0), true},
        });
    }
    
    @Test
    public void testOnOneLine() {
        Assert.assertEquals(expectedResult, Point.onOneLine(testPoint1, testPoint2, testPoint3));
    }
}
