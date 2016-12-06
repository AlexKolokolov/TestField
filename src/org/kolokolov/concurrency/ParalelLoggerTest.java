package org.kolokolov.concurrency;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

public class ParalelLoggerTest {
    public static void main(String[] args) {
        Logger logger = new Logger();
        for (int i = 0; i < 10_000_000; i++) {
            if (Double.valueOf(i) % 100_000 == 0) System.out.println(i);
            if (Double.valueOf(i) % 1_000_000 == 0) logger.log(String.valueOf(i));          
        }
        logger.close();
    }
}

class Logger extends Thread {
    
    private Queue<String> buffer = new LinkedTransferQueue<>();
    private boolean isClosed = false;
    
    public Logger() {
        start();
    }
    
    @Override
    public void run() {
        while (!isClosed || !buffer.isEmpty()) {
            doSomething();
            System.err.println("Logging: " + getFirstFromBuffer()); 
        }
    }
    
    private synchronized void saveToBuffer(String str) {
        buffer.offer(str);
        notifyAll();
    }
    
    private synchronized String getFirstFromBuffer() {
        try {
            while (buffer.isEmpty()) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buffer.poll();
    }
    
    public void close() {
        isClosed = true;
    }
    
    public void log(String str){
        saveToBuffer(str);
    }
    
    private void doSomething() {
        Random rnd = new Random();
        for (int i = 0; i < 5_000_000; i++) {
            
            int j = i + rnd.nextInt(100);
        }
    }
}