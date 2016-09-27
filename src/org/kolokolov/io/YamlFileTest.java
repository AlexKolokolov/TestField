package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.kolokolov.steams.TestTask;

public class YamlFileTest {

    public static void writeIntListToFile(List<Integer> list, String fileName) {
        File file = new File(fileName);
        File dir = file.getParentFile();
        createDirectory(dir);
        try (FileWriter fWriter = new FileWriter(file)) {
            fWriter.write("-Integers\n");
            for (int n : list) {
                fWriter.write(String.valueOf(n) + "\n");
            }
            System.out.printf("List %s\nhas been successfully persisted to the %s\n", list, file.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Integer> readIntegersFromFile(String filename) {
        if (filename != null) {
            File file = new File(filename);
            if (file.exists()) {
                List<Integer> list = new ArrayList<>();
                try (FileReader fReader = new FileReader(file);
                        BufferedReader reader = new BufferedReader(fReader)) {
                    System.out.printf("Encoding: %s%n", fReader.getEncoding());
                    if ("-Integers".equals(reader.readLine())) {
                        String str = null;
                        while ((str = reader.readLine()) != null) {
                            list.add(Integer.parseInt(str));
                        }
                        System.out.printf("List %s\nhas been successfully retrieved from %s\n", list,
                                file.getAbsolutePath());
                        return list;
                    } return null;
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
        List<Integer> list = TestTask.createRandomList(30);
        String fileName = "test/integers.yaml";

        writeIntListToFile(list, fileName);

        List<Integer> retrievedList = readIntegersFromFile(fileName);

        System.out.printf("The lonely integer in the list is %d\n", TestTask.findAloneInt(retrievedList));
    }

}
