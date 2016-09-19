package org.kolokolov.lambdas.methodreferences;

public class Demo {
    
    public static boolean testInt(IntTester tester, int n){
        return tester.test(n);
    }
    
    public static void main(String[] args) {
        int n1 = 2;
        boolean result1 = testInt((n) -> (n & 1) == 0, n1);
        System.out.println(result1);  
        
        int n2 = 10;
        boolean result2 = testInt(IntTesterClass::isEven, n1);
        System.out.println(result2);
        
        IntTester isEven = (n) -> (n & 1) == 0;
        
        int n3 = 20;
        boolean result3 = testInt(isEven, n1);
        System.out.println(result3);
    }
}
