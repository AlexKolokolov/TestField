package org.kolokolov.nestedClasses;

class OuterClass {
    int i = 10;
    static int si = 100;
    
    class InnerClass {
        int ii = 11;
        final static int iis = 110; //static variable in non-static inner class has to be final
        
        //Static method are forbidden here
//        static void staticMethod() {
//            System.out.println("Static method of non-static inner class");
//        }
        
        void nonStaticMethod() {
            System.out.println("Non-static method of non-static inner class");
            System.out.println("Non-static variable of the outer class: " + i);
            System.out.println("Static variable of the outer class: " + si);
        }  
    }
    
    static class StaticInnerClass {
        int sii = 12;
        static int siis = 120;
        
        void nonStaticMethod() {
            System.out.println("Non-static method of static inner class");
            System.out.println("Static variable of the outer class: " + si);
        }
        
        static void staticMethod() {
            System.out.println("Static method of static inner class");
            System.out.println("Static variable of the outer class: " + si);
        }
    }
}

public class NestedClassDemo {
    
    public static void main(String[] args) {
        System.out.println(OuterClass.InnerClass.iis);
        System.out.println(new OuterClass().new InnerClass().ii);
        System.out.println(OuterClass.StaticInnerClass.siis);
        System.out.println(new OuterClass.StaticInnerClass().sii);
        
        new OuterClass().new InnerClass().nonStaticMethod();
        OuterClass.StaticInnerClass.staticMethod();
        new OuterClass.StaticInnerClass().nonStaticMethod();
    }
}
