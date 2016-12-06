package org.kolokolov.concurrency;

public class DeadLockTest {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    
    public void method1() {
        System.out.println("Method 1 started");
        
        synchronized (lock1) {
            System.out.println("Iside method 1 first synchronized block");
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("Inside method 1 second synchronized block");
            }
        }
    }
    
    public void method2() {
        System.out.println("Method 2 started");
        
        synchronized (lock2) {
            System.out.println("Iside method 2 first synchronized block");
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("Inside method 2 second synchronized block");
            }
        }
    }
    
    public static void main(String[] args) {
        DeadLockTest dlt = new DeadLockTest();
        Thread thread1 = new Thread(() -> dlt.method1());
        Thread thread2 = new Thread(() -> dlt.method2());
        
        thread1.start();
        thread2.start();
    }

}
