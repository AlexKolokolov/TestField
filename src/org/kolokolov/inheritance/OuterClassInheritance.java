package org.kolokolov.inheritance;

public class OuterClassInheritance {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }
}

class Outer {
    String msg = "Alarm!";
    static String sctaticMsg = "Static Alarm!";
    
    void printMessage(String msg) {
        System.out.println(msg);
    }
    
    class Inner {
        
        String msg = "Inner Alarm!";
        
        public Inner() {
            System.out.println("I am the inner class");
        }
        
        void print() {
            printMessage(this.msg);
            printMessage(Outer.this.msg);
            printMessage(Outer.sctaticMsg);
        }
    }
}