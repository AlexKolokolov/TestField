package org.kolokolov.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProduserConsumer {
    
    private static BlockingQueue<String> buffer = new LinkedBlockingQueue<>(3);
    
    public static void addStrings(String[] strings) throws InterruptedException {
        for (String str : strings) {
            System.out.println("Adding " + str);
            buffer.put(str);
            Thread.sleep(1000);
        }
    }
    
    public static void consumeStrings() throws InterruptedException {
        Thread.sleep(5000);
        String str = null;
        do {
            Thread.sleep(3000);
            str = buffer.take();
            System.out.println("Consuming " + str);
        } while (str != "Neptune");
    }
    
    public static void runInNewThread(Runnable runnable) {
        new Thread(runnable).start();
    }
    
    public static void runAsNewDaemon(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }
    
    public static void main(String[] args) {
        String[] strings = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        runInNewThread(() -> {
            try {
                addStrings(strings);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        runInNewThread(() -> {
            try {
                consumeStrings();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    

}
