package org.kolokolov.unittests.figures.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kolokolov.unittests.figures.Point;
import org.kolokolov.unittests.figures.Triangle;

import org.junit.Assert;

public class TriangleTest {
    private static Triangle testTriangle1;
    
    @BeforeClass
    public static void createTestTriangles(){
        System.out.println("Triangle test started");
        testTriangle1 = new Triangle(new Point(0,0), new Point(0,2), new Point(2,2));
    }
    
    @AfterClass
    public static void afterTest() {
        System.out.println("Triangle test completed");
    }
    
    @Test
    public void testTriangleToString() {
        Assert.assertEquals("[(0.0,0.0),(0.0,2.0),(2.0,2.0)]", testTriangle1.toString());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullArgumentTriangleConstructorTest() {
        new Triangle(new Point(0,0), new Point(1,1), null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void onOneLineVerticesTriangleConstructorTest() {
        new Triangle(new Point(0,0), new Point(1,1), new Point(2,2));
    }
    
    @Test(expected = IllegalStateException.class)
    public void equalVerticesTriangleConstructorTest() {
        new Triangle(new Point(0,0), new Point(0,0), new Point(2,2));
    }
    
    @Test
    public void testSquare() {
        Assert.assertEquals(2, testTriangle1.square(), 0.0001);
    }
}   
