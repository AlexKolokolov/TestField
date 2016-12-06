package org.kolokolov.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    
    private static final class CallableImpl implements Callable<String> {
        @Override
        public String call() throws Exception {
            long threadId = Thread.currentThread().getId();
            for (int i = 0; i < 10; i++) {
                System.out.printf("Line %d from thread #%d%n", i, threadId);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            return String.format("Thread #%d is completed", threadId);
        }
    }
    
    

    public static void main(String[] args) {
        
        int[] array = {10, 20, 30, 40};
        
        Callable<Integer> demo = () -> {
            int sum = 0;
            for (int elem : array) {
                sum += elem;
                System.out.printf("Intermidiate sum in thread #%d is %d%n", Thread.currentThread().getId(), sum);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
            return sum;
        };
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<Integer> future1 = pool.submit(demo);
        Future<String> future2 = pool.submit(new CallableImpl());
        Future<String> future3 = pool.submit(new CallableImpl());
        Future<String> future4 = pool.submit(new CallableImpl());
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
            System.out.println(future4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
