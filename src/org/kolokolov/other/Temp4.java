package org.kolokolov.other;

public class Temp4 {
    public static void main(String[] args) {
        new BB();
    }
}

class AA {
    {
        System.out.println("AA init block");
    }
    
    static {
        System.out.println("AA static init block");
    }
    
    AA() {
        System.out.println("AA constructor");
    }
}

class BB extends AA {
    {
        System.out.println("BB init block");
    }
    
    static {
        System.out.println("BB static init block");
    }
    
    BB() {
        System.out.println("BB constructor");
    }
}