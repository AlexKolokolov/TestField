package org.kolokolov.exceptions;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try {
            int x = 1;
            System.out.println("Inside the try block before exception");
            if (x == 1) throw new Exception("I'm an exception!");
            System.out.println("Inside the try block after exception");
        } catch (Exception e){
            System.out.println("Inside the catch block. I caught an exception: " + e.getMessage());
        } finally {
            System.out.println("Inside the finaly block");
        }
        System.out.println("After the try block");
    }

}
