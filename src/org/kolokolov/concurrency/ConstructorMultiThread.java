package org.kolokolov.concurrency;

public class ConstructorMultiThread {
    
    public static void main(String[] args) {
        new MyRunnable();
        new MyRunnable();
    }

}
