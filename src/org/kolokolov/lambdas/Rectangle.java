package org.kolokolov.lambdas;

public class Rectangle {
    private double width;
    private double hight;
    
    
    public Rectangle(double width, double hight) {
        this.width = width;
        this.hight = hight;
    }
    
    public double evaluate(RectangleHandler handler) {
        return handler.evaluate(width, hight);
    }
}
