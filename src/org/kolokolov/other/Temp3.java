package org.kolokolov.other;

public class Temp3 {
    public static void main(String[] args) {
        A a = new B();
    }

}

class A {
    A() {
        System.out.println("A");
        a();
    }
    
    void a() {
        System.out.println("a");
    }
}

class B extends A {
    B() {
        System.out.println("B");
        a();
    }
    
    void a() {
        System.out.println("b");
    }
    
}
