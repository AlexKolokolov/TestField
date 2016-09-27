package org.kolokolov.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kolokolov.steams.TestTask;

public class DataFileTest {

    public static void writeIntListToFile(List<Integer> list, String fileName) {
        File file = new File(fileName);
        File dir = file.getParentFile();
        createDirectory(dir);
        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(file))) {
            for (int n : list) {
                dataOut.writeInt(n);
            }
            System.out.printf("List %s\nhas been successfully written to the %s\n", list, file.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Integer> readIntegersFromFile(String filename) {
        if (filename != null) {
            File file = new File(filename);
            if (file.exists()) {
                List<Integer> list = new ArrayList<>();
                try (DataInputStream dataIn = new DataInputStream(new FileInputStream(file))) {
                    while (dataIn.available() > 0) {
                        list.add(dataIn.readInt());
                    } 
                    System.out.printf("List %s\nhas been successfully retrieved from %s\n", list, file.getAbsolutePath());
                    return list;
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return null;
                }    
            }        
        }
        return null;
    }

    private static void createDirectory(File directory) {
        if (directory != null && !directory.exists() && directory.mkdirs()) {
            System.out.printf("Directory [%s] has been successfully created\n", directory);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = TestTask.createRandomList(20);
        String fileName = "test/integers.dat";
        
        writeIntListToFile(list, fileName);
        
        List<Integer> retrievedList = readIntegersFromFile(fileName);
        
        System.out.printf("The lonely integer in the list is %d", TestTask.findAloneInt(retrievedList));
    }

}
