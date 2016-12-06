package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;

public class PipedStreamTest {

    public static void writeToPipedStream(OutputStream out, String str) {
        PrintWriter writer = new PrintWriter(out, true);
        writer.println(str);
    }

    public static String readFromPipedStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String str = reader.readLine();
        return str;
    }

    public static void main(String[] args) {
        try (PipedOutputStream output = new PipedOutputStream();
                PipedInputStream input = new PipedInputStream(output)) {

            Thread inputThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (true) {
                        System.out.print("Enter a string: ");
                        String str = reader.readLine();
                        writeToPipedStream(output, str);
                        Thread.sleep(100);
                        if ("exit".equals(str))
                            break;
                    }
                    System.out.println("Input thread is over");
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            });

            inputThread.start();

            System.out.println("Output started");
            while (true) {
                String str = readFromPipedStream(input);
                if ("exit".equals(str))
                    break;
                System.out.println("Output: " + str);
            }
            System.out.println("Main (output) thread is over");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
