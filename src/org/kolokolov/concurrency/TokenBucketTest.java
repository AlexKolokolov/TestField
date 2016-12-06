package org.kolokolov.concurrency;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketTest {
    private int bucket;

    private final long LIMIT = 100;

    private Lock lock = new ReentrantLock();
    private Condition notFullBucket = lock.newCondition();
    private Condition enoughTokens = lock.newCondition();

    public void fillBucket(int n) throws InterruptedException {
        lock.lock();
        while (bucket >= LIMIT) {
            System.out.println("Cannot add " + n);
            notFullBucket.await();
        }
        bucket += n;
        System.out.println("Adding " + n);
        enoughTokens.signalAll();
        lock.unlock();
    }

    public void emptyBucket(int n) throws InterruptedException {
        lock.lock();
        while (bucket < n) {
            System.out.println("Cannot subtrackt " + n);
            enoughTokens.await();
        }
        bucket -= n;
        System.out.println("Subtracting " + n);
        notFullBucket.signalAll();
        lock.unlock();
    }

    public Thread repeatInNewThread(Runnable runnable, int times) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < times; i++) {
                runnable.run();
            }
        });
        thread.start();
        return thread;
    }

    public Thread repeatInDaemonThread(Runnable runnable) {
        Thread thread = new Thread(() -> {
            while (true) {
                runnable.run();
            }
        });
        thread.setDaemon(true);
        thread.start();
        return thread;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketTest tokenBucket = new TokenBucketTest();
        Random rnd = new Random();

        Thread filler = tokenBucket.repeatInDaemonThread(() -> {
            try {
                tokenBucket.fillBucket(rnd.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread emptier = tokenBucket.repeatInNewThread(() -> {
            try {
                tokenBucket.emptyBucket(rnd.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 20);

        emptier.join();
        System.out.println("TokenBucket = " + tokenBucket.bucket);
    }

}
