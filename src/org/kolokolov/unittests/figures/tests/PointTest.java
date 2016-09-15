package org.kolokolov.unittests.figures.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kolokolov.unittests.figures.Point;

public class PointTest {
    
    private static Point testPoint1;
    private static Point testPoint2;
    
    @BeforeClass
    public static void createTestPoints() {
        System.out.println("Point test started");
        testPoint1 = new Point(3,4);
        testPoint2 = new Point(0,0);
    }
    
    @AfterClass
    public static void afterTests() {
        System.out.println("Point test completed");
    }
    
    @Test
    public void testPointToString() {
        Assert.assertEquals("(3.0,4.0)", testPoint1.toString());
    }
    
    @Test
    public void testDistanceTo() {
        Assert.assertEquals(5, testPoint1.distanceTo(testPoint2), 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDistanceToException() {
        testPoint1.distanceTo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testOnOneLineException() {
        Point.onOneLine(new Point(1,2), new Point(2,3), null);
    }
}
