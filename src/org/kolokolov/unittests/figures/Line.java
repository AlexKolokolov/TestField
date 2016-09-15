package org.kolokolov.unittests.figures;

public class Line {
    private Point pointA;
    private Point pointB;
    
    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public String toString() {
        return "[" + pointA + "," + pointB + "]";
    }
    
    public double length() {
        return pointA.distanceTo(pointB);
    }
}
