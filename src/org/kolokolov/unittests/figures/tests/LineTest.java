package org.kolokolov.unittests.figures.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kolokolov.unittests.figures.Line;
import org.kolokolov.unittests.figures.Point;

public class LineTest {
    private static Line testLine1;
    
    @BeforeClass
    public static void createTestLines() {
        System.out.println("Line test started");
        testLine1 = new Line(new Point(0,0), new Point(3,4));
    }
    
    @AfterClass
    public static void afterTests() {
        System.out.println("Line tests complited");
    }
    
    @Test
    public void testLineToString() {
        Assert.assertEquals("[(0.0,0.0),(3.0,4.0)]", testLine1.toString());
    }
    
    @Test
    public void testLength() {
        Assert.assertEquals(5, testLine1.length(), 0.0);
    }
}
