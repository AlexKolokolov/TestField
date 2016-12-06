package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class EncodingTest2 {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8))) {
            String str = reader.readLine();
            System.out.println("Out: " + str);
            writer.println("Out2: " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
