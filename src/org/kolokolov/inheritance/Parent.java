package org.kolokolov.inheritance;

public class Parent {
    String name = "Parent";
    
    void parentMethod() {
        System.out.println("Inside the parrent method");
    }
    
    public static void main(String[] args) {
        Child ch = new Child();
        ch.parentMethod();
        ch.anotherMethod();
    }
}

class Child extends Parent {
    String name = "Child";
    

    void parentMethod() {
        System.out.println("Inside the overriden parrent method");
        System.out.println("Child's name: " + this.name);
        System.out.println("Parent's name: " + super.name);
        super.parentMethod();
    }
    
    void anotherMethod() {
        System.out.println("Inside another method");
        super.parentMethod();
    }
}
