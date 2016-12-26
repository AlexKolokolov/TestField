package org.kolokolov.overriding;


class A {
    int i = 10;
    
    static int si = 10;
    
    static void greet() {
        System.out.println("Hello from A!");
    }
}

class B extends A {
    int i = 100;
    
    static void greet() {
        System.out.println("Hello from B!");
    }
}

public class OverridingDemo {
    
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.i);
        A.greet();
        
        A b = new B();
        System.out.println(b.i);
        System.out.println(b.si);
        
        B b2 = new B();
        System.out.println(b2.i);
        System.out.println(b2.si);
        System.out.println(B.si);
        B.greet();
    }
}
