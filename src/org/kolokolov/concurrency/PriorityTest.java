package org.kolokolov.concurrency;

public class PriorityTest implements Runnable {
    private int counter;
    private static volatile boolean stop = false;
    
    private Thread thread;
    
    public PriorityTest(int priority, String name) {
        thread = new Thread(this, name);
        thread.setPriority(priority);
        thread.start();
    }
    
    @Override
    public void run() {
        System.out.println("Tread " + thread.getName() + " started");
        while (!stop && counter < 10_000_000) {
            counter++;
            if (counter > 10_000) throw new RuntimeException("Test exception");
        }
        
        stop = true;
        System.out.println("Tread " + thread.getName() + " stopped");
    }
    
    public static void main(String[] args) {
        PriorityTest pt1 = new PriorityTest(1, "Low Priopiry");
        PriorityTest pt2 = new PriorityTest(5, "Average Priority");
        PriorityTest pt3 = new PriorityTest(10, "High Priority");
        
        try {
            pt1.thread.join();
            pt2.thread.join();
            pt3.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Thread " + pt1.thread.getName() + " counter = " + pt1.counter);
        System.out.println("Thread " + pt2.thread.getName() + " counter = " + pt2.counter);
        System.out.println("Thread " + pt3.thread.getName() + " counter = " + pt3.counter);        
    }
}
