package org.kolokolov.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;

public class InputOutputTest {
    public static void main(String[] args) {
        Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            out.write("Hello!\n");
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        PrintStream outStream = new PrintStream(System.out);
        outStream.println("Hello!");

        try {
            int a = 0;
            while (a == 0) {
                a = System.in.available();
            }
            byte[] in = new byte[a];
            System.in.read(in);
            System.out.write(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
