package org.kolokolov.concurrency;

/**
 * Test proves that volatile doesn't help in case of none-atomic operation.
 * 
 * @author kolokolov
 *
 */

public class VolatileTest {
    static volatile int x;
    public static void main(String[] args) throws Exception {
        do {
            x = 100;
            Thread t2 = new Thread(() -> x += 20);
            Thread t3 = new Thread(() -> x += 30);
            t2.start();
            t3.start();
            x += 10;
            t2.join();
            t3.join();
            System.out.println(x);
        } while (x == 160);
    }
    
}
