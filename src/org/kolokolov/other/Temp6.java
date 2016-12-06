package org.kolokolov.other;

public class Temp6 {
    public static void main(String[] args) {
        System.out.println(TestEnum.A);
    }
}

enum TestEnum {
    A(1), B(2), C(3);
    
    TestEnum(int i) {
        System.out.println(i);
    }
    
    static {
        System.out.println("Static");
    }
}