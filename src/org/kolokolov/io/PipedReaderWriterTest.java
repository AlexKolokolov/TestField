package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class PipedReaderWriterTest {
    public static void main(String[] args) {
        try (PipedWriter pWriter = new PipedWriter();
                PrintWriter writer = new PrintWriter(pWriter, true);
                BufferedReader bReader = new BufferedReader(new PipedReader(pWriter))) {
            
            Thread main = Thread.currentThread();
            
            new Thread(() -> {
                try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
                    while (true) {
                        System.out.print("Enter a string: ");
                        String str = console.readLine();
                        writer.println(str);
                        Thread.sleep(100);
                        if ("exit".equals(str)) break;
                    }
                    System.out.println("Input thread is over");
                    main.join();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            
            while (true) {
                String result = bReader.readLine();
                if ("exit".equals(result)) break;
                System.out.println("Output: " + result);
            }
            System.out.println("Output thread is over");
                    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
