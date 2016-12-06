package org.kolokolov.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class SpeedLimitTest {
    private int bucket;
    private int bufferSize = 1024;
    

    public void fillBucket(int speed) {
        int delay = 5;
        int stepSize = 1024 * speed * delay / 1000 / 8;
        int limit = bufferSize > stepSize ? bufferSize * 2 : stepSize * 2;
        bucket = limit;

        System.out.printf("Speed limit = %d kbit/s%n", speed);
        System.out.printf("Delay = %d ms%n", delay);
        System.out.printf("Step size = %d B%n", stepSize);
        Thread bucketFiller = new Thread(() -> {
            while (true) {
                try {
                    synchronized (this) {
                        while (bucket >= limit) {
                            this.wait();
                        }
                        bucket += stepSize;
                        Thread.sleep(delay);
                        notifyAll();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        bucketFiller.setDaemon(true);
        bucketFiller.start();
    }

    public void copyFile(File source, File target) {

        fillBucket(10000);

        long startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(source);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target))) {
            System.out.printf("File %s downloading started%n", source.getName());
                copyBytsIfAllowed(fis, bos);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        long byteSize = target.length();
        long estimatedTime = System.currentTimeMillis() - startTime;
        long averageSpeed = 1000 * byteSize / estimatedTime;
        System.out.printf("File %s : %.02f kB downloaded at %d kbit/s%n", target.getName(), (double) byteSize / 1024,
                averageSpeed * 8 / 1024);

    }
    
    public void downloadFile(URL source, File target) {

        fillBucket(50000);

        long startTime = System.currentTimeMillis();
        try (InputStream fis = source.openStream();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target))) {
            System.out.printf("File %s downloading started%n", source.getPath());
                copyBytsIfAllowed(fis, bos);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        long byteSize = target.length();
        long estimatedTime = System.currentTimeMillis() - startTime;
        long averageSpeed = 1000 * byteSize / estimatedTime;
        System.out.printf("File %s : %.02f kB downloaded at %d kbit/s%n", target.getName(), (double) byteSize / 1024,
                averageSpeed * 8 / 1024);

    }
    
    

    public void copyBytsIfAllowed(InputStream source, OutputStream target) throws IOException, InterruptedException {
        int count;
        byte[] buffer = new byte[bufferSize];
        while ((count = source.read(buffer)) != -1) {
            synchronized (this) {
                while (bucket < count) {
                    this.wait();
                }
//                System.out.println(count);
                bucket -= count;
                notifyAll();
            }
            target.write(buffer, 0, count);
        }
        target.flush();
    }

    public static void main(String[] args) throws IOException {
        SpeedLimitTest slt = new SpeedLimitTest();
        slt.copyFile(new File("./test/jaxrs-ri-2.23.1.zip"),
                new File("./test/new_jaxrs-ri-2.23.1.zip"));
//        slt.copyFile(new File("./test/kitten6.jpg"),
//                new File("./test/new_kitten6.jpg"));
//        URL link = new URL("http://www.ex.ua/get/22144799");
//        slt.downloadFile(link, new File("./test/book.pdf"));
    }
}
