package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileInputOutput {

    public static void writeToFile(String str, String fileName) {
        File file = new File(fileName);
        File dir = file.getParentFile();
        if (dir !=null && !dir.exists()) {
            if(!dir.mkdirs()) {
                System.out.printf("Directory [%s] unable to be creatred\n", dir);
                return;
            }
        }
        try (PrintWriter pWriter = new PrintWriter(new FileOutputStream(file))) {
            pWriter.println(str);
            pWriter.flush();
            System.out.printf("String %s was written to %s\n", str, file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeCharsToFile(String str, String fileName) {
        File file = new File(fileName);
        File dir = file.getParentFile();
        if (dir !=null && !dir.exists()) {
            if(!dir.mkdirs()) {
                System.out.printf("Directory [%s] unable to be creatred\n", dir);
                return;
            }
        }
        try (FileWriter fWriter = new FileWriter(file)) {
            fWriter.write(str);
            fWriter.flush();
            System.out.printf("String %s was written to %s\n", str, file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                return reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("File does not exist");
            return null;
        }
    }
    
    public static String readCharsFromFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                return reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("File does not exist");
            return null;
        }
    }

    public static void writeToCompressedFile(String str, String fileName) {
        File file = new File(fileName);
        File dir = file.getParentFile();
        if (dir !=null && !dir.exists()) {
            if(!dir.mkdirs()) {
                System.out.printf("Directory [%s] unable to be creatred\n", dir);
                return;
            }
        }
        try (PrintWriter pWriter = new PrintWriter(new GZIPOutputStream(new FileOutputStream(file)))) {
            pWriter.println(str);
            pWriter.flush();
            System.out.printf("String %s was written to %s\n", str, file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromCompressedFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName))))) {
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readLineFromConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        String name = readLineFromConsole();

        String str = String.format("Hello, %s!", name);
        String fileName = "out/textfile.out";

        writeToFile(str, fileName);
        System.out.println(readFromFile(fileName));

        String str2 = String.format("Hello again, %s!", name);
        String compressedFileName = "out/textfile.gz";

        writeToCompressedFile(str2, compressedFileName);
        System.out.println(readFromCompressedFile(compressedFileName));
        
        String str3 = String.format("Third hello, %s!", name);
        String anotherFileName = "out/anotherTextFile.out";
        
        writeCharsToFile(str3, anotherFileName);
        System.out.println(readCharsFromFile(anotherFileName));
    }

}
