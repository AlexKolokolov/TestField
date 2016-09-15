package org.kolokolov.unittests.figures;

public class Point {
    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distanceTo(Point anotherPoint) {
        if (null == anotherPoint) {
            throw new IllegalArgumentException("Another point must not be null");
        }
        return Math.sqrt(Math.pow(this.x - anotherPoint.x,2) + Math.pow(this.y - anotherPoint.y,2));
    }
    
    public static boolean onOneLine(Point point1, Point point2, Point point3) {
        if (null == point1 || null == point2 || null == point3) {
            throw new IllegalArgumentException("Points must not be null");
        }
        
        if (point1.equals(point2) || point2.equals(point3) || point1.equals(point3)) return true;
        
        double distance12 = point1.distanceTo(point2);
        double distance23 = point2.distanceTo(point3);
        double distance13 = point1.distanceTo(point3);
        if (distance12 == distance13 + distance23 
                || distance23 == distance12 + distance13 
                || distance13 == distance12 + distance23) 
            return true;
    
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
