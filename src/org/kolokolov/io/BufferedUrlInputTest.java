package org.kolokolov.io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class BufferedUrlInputTest {
    public static void main(String[] args) throws Exception {
        String sUrl = "https://www.google.com.ua";
        URL url = new URL(sUrl);
        InputStream inet = url.openStream();

        long startTime = System.currentTimeMillis();
        try (ByteArrayOutputStream data = new ByteArrayOutputStream();
                FileOutputStream file = new FileOutputStream("test/google.html")) {

            int count;
            byte[] buffer = new byte[1024];
            while ((count = inet.read(buffer)) != -1) {
                data.write(buffer, 0, count);
                file.write(buffer, 0, count);
            }
            data.flush();
            file.flush();

            byte[] bytes = data.toByteArray();

            String result = new String(bytes, "cp1251");

            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);

    }

}
