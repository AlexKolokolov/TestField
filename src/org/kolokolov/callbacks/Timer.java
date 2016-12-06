package org.kolokolov.callbacks;

public class Timer {
    
    public void logOnTimer(int repeats, int delay, Logger logger) {
        new Thread(() -> {
            int counter = repeats;
            while (counter-- > 0)
                try {
                    Thread.sleep(delay * 1000);
                    logger.log();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
        }).start();
    }
}
