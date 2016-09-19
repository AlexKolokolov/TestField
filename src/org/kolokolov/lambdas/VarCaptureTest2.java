package org.kolokolov.lambdas;

public class VarCaptureTest2 {
    public static void main(String[] args) {
        int var = 10;
        doSomething((n) -> n * var);
    }
    
    public static void doSomething(MyFunc2 func) {
        System.out.println(func.func(2));
    }
}

interface MyFunc2 {
    int func(int n);
}
