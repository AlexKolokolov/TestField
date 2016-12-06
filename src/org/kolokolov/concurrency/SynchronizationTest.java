package org.kolokolov.concurrency;

public class SynchronizationTest {
    private static int result = 0;

    /*
     *  This method gives correct result with synchronized
     *  modifier only
     */
    public static synchronized int sumArray(int[] array) {
        result = 0;
        for (int elem : array) {
            result += elem;
            System.out.printf("Intermediate result for thread #%d = %d%n", Thread.currentThread().getId(), result);
            try {
                Thread.sleep(10);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 5, 10, 20, 60};
        int[] array2 = {10, 20, 60, 5, 5};
        int[] array3 = {60, 20, 10, 5, 5};
        int[] arrayMain = {5, 60, 10, 20, 5};

        Thread thread1 = new Thread(() -> System.out.println(sumArray(array1)));
        thread1.start();
        Thread thread2 = new Thread(() -> System.out.println(sumArray(array2)));
        thread2.start();
        Thread thread3 = new Thread(() -> System.out.println(sumArray(array3)));
        thread3.start();
        System.out.println(sumArray(arrayMain));
    }
}
