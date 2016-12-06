package org.kolokolov.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo2 {
    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50 };
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<Integer> summingProcess = pool.submit(() -> sumArray(array));
        Future<Integer> multiplicationProduct = pool.submit(() -> multiplyArray(array));
        int[] anotherArray = {1, 2, 3, 4, 5};
        System.out.println("Anoter sum is " + sumArray(anotherArray));
        try {
            int sum = summingProcess.get();
            int product = multiplicationProduct.get();
            System.out.println("Sum is " + sum);
            System.out.println("Product is " + product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static int sumArray(int[] array) {
        long threadId = Thread.currentThread().getId();
        int sum = 0;
        for (int elem : array) {
            sum += elem;
            System.out.printf("Imtermediate sum in thread #%d is %d%n", threadId, sum);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        return sum;
    }

    public static int multiplyArray(int[] array) {
        long threadId = Thread.currentThread().getId();
        int prod = 1;
        for (int elem : array) {
            prod *= elem;
            System.out.printf("Imtermediate product in thread #%d is %d%n", threadId, prod);
//            if (prod > 1000) prod /= 0;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        return prod;
    }

}
