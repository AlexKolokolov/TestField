package org.kolokolov.hadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Mapper {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            lines.stream().flatMap(l -> Stream.of(l.split(" "))).forEach(w -> System.out.println(w + "\t1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
