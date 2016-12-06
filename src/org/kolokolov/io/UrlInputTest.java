package org.kolokolov.io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class UrlInputTest {
    public static void main(String[] args) throws Exception {
        String sUrl = "https://www.google.com.ua";
        URL url = new URL(sUrl);
        InputStream inet = url.openStream();
        
        long startTime = System.currentTimeMillis();
        try (ByteArrayOutputStream data = new ByteArrayOutputStream();
                FileOutputStream file = new FileOutputStream("test/google.html")) {

            int elem;
            while ((elem = inet.read()) != -1) {
                data.write(elem);
                file.write(elem);
            }
            data.flush();
            file.flush();

            byte[] bytes = data.toByteArray();

            String result = new String(bytes, "cp1251");

            System.out.println(result);
        }
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);

    }

}
