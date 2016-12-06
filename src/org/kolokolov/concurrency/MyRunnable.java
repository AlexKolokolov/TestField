package org.kolokolov.concurrency;

import java.util.Random;

class MyRunnable implements Runnable {
    Thread thread;
    
    public MyRunnable() {
        this.thread = new Thread(this);
        this.thread.start();
    }
    
    @Override
    public void run() {
        Random rnd = new Random();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("This is the line #" + i + " from thread #" + Thread.currentThread().getId());
                Thread.sleep(rnd.nextInt(200));
            }
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new MyRunnable();
        new MyRunnable();
        new MyRunnable();
    }
}