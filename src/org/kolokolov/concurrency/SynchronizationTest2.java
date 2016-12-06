package org.kolokolov.concurrency;

public class SynchronizationTest2 {

    public synchronized int increment5Times(int number) {
        for (int i = 0; i < 5; i++) {
            number++;
            System.out.printf("Intermediate result for increment5Times = %d%n", number);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        return number;
    }

    public int increment10Times(int number) {
        for (int i = 0; i < 10; i++) {
            number++;
            System.out.printf("Intermediate result for increment10Times = %d%n", number);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        return number;
    }

    public static void main(String[] args) {
        SynchronizationTest2 st2 = new SynchronizationTest2();
        Thread thread1 = new Thread(() -> st2.increment5Times(100));
        Thread thread2 = new Thread(() -> {
            synchronized (st2) {
                st2.increment10Times(200);
            }
        });
        thread1.start();
        thread2.start();
    }
}
