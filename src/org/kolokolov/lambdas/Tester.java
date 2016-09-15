package org.kolokolov.lambdas;

public class Tester {
    public static void main(String[] args) {
        
        //First rectangle uses classic functional interface application
        Rectangle rectangle1 = new Rectangle(3, 4);
        RectangleHandler squareCalculator = new RectangleHandler() {
            @Override
            public double evaluate(double width, double hight) {
                return width * hight;
            }
        };
        double square1 = rectangle1.evaluate(squareCalculator);
        System.out.println("First rectangle's square = " + square1);
        
        //Second rectangle uses one type of lambda expression application
        Rectangle rectangle2 = new Rectangle(5, 10);
        double perimeter2 = rectangle2.evaluate((x, y) -> 2 * (x + y));
        System.out.println("Second rectangle's perimeter = " + perimeter2);
        
        //Third rectangle uses another type of lambda expression application
        Rectangle rectangle3 = new Rectangle(10, 15);
        RectangleHandler square = (width, hight) -> hight * width;
        RectangleHandler perimeter = (width, hight) -> 2 * (width + hight);
        double scuare3 = rectangle3.evaluate(square);
        double perimeter3 = rectangle3.evaluate(perimeter);
        System.out.println("Third rectangle's square = " + scuare3 + ", and perimeter = " + perimeter3);
    }
}
