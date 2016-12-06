package org.kolokolov.other;

public class Temp1 {
    
    static int i = 1;
    int ii = 1;
    
    {
        ii = 10;
        System.out.println("First init block");
    }
    
    {
        ii = 20;
        System.out.println("Second init block");
    }
    
    static {
        i = 10;
        System.out.println("First static init block");
    }
    
    public Temp1() {
        ii = 50;
        System.out.println("Constructor");
    }
    
    
    public static void main(String[] args) {
        Temp1 t = new Temp1();
        System.out.println(i);
        System.out.println(t.ii);
    }
    

    static {
        i = 20;
        System.out.println("Second static init block");
    }
    
    

}


