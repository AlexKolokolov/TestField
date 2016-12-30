package org.kolokolov.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("test/settings.properties")) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String name = props.getProperty("name");
        String email = props.getProperty("email");
        
        System.out.println("Name: " + name);
        System.out.println("E-mail: " + email);
    }
}
