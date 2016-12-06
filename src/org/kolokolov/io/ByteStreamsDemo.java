package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ByteStreamsDemo {
    public static void main(String[] args) {

        String str = "ABCDE";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            PrintStream ps = new PrintStream(baos, true, "UTF-16");
            ps.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        

        byte[] targetArray = baos.toByteArray();
        
        System.out.println(Arrays.toString(targetArray));

        ByteArrayInputStream bais = new ByteArrayInputStream(targetArray);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(bais, StandardCharsets.UTF_16));
            System.out.println(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
