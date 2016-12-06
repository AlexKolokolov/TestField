package org.kolokolov.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Random;

public class ParalelLoggerTest2 {
    public static void main(String[] args) {
        PipedLogger logger = new PipedLogger();
        for (int i = 0; i < 10_000_000; i++) {
            if (Double.valueOf(i) % 100_000 == 0) System.out.println(i);
            if (Double.valueOf(i) % 1_000_000 == 0) logger.log(String.valueOf(i));          
        }
        logger.close();
    }
}

class PipedLogger extends Thread {
    
    private PipedWriter output;
    private PipedReader input;
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean isClosed = false;
    
    public PipedLogger() {
        input = new PipedReader();
        reader = new BufferedReader(input);
        try {
            output = new PipedWriter(input);
            writer = new PrintWriter(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }
    
    @Override
    public void run() {
        try {
            while (!isClosed || input.ready()) {
                doSomething();
                System.err.println("Logging: " + getFromBuffer()); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void saveToBuffer(String str) {
        writer.println(str);
    }
    
    private String getFromBuffer() {
        try {
            return reader.readLine();  
        } catch (Exception e) {
           e.printStackTrace();
           return "Error";
        }
        
    }
    
    public void close() {
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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