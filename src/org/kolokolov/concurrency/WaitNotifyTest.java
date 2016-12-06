package org.kolokolov.concurrency;



public class WaitNotifyTest {
    private String status = "tick";
    
    public synchronized void ticker() {
        while (status.equals("tock")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Tick");
        status = new String("tock");
        notify();
    }
    
    public synchronized void tocker() {
        while (status.equals("tick")) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Tock");
        status = new String("tick");
        notify();
    }
    
    public static void main(String[] args) {
        WaitNotifyTest wnt = new WaitNotifyTest();
        
        Thread ticker = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                wnt.ticker();
            }
        });
        
        Thread tocker = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                wnt.tocker();
            }
        });
        
        ticker.start();
        tocker.start();
    }

}
