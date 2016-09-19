package org.kolokolov.lambdas;

public class VarCaptureTest {
    public static void main(String[] args) {
        int var = 10;
        
        //Next line is unacceptable
        //var = 100;
        
        MyFunc myFunc = (n) -> {
            
            //This one too
            //var = 100;
            
            return n * var;
            };
        
        System.out.println(myFunc.func(2));
        
        //And even this one
        //var = 100;
    }
}

interface MyFunc {
    int func(int n);
}
