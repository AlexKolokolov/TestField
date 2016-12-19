package org.kolokolov.hadoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Mapper3 {
    public static void main(String[] args) {
        // put your code here
          try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
              List<String> lines = new ArrayList<>();
              String line;
              while ((line = reader.readLine()) != null) {
                  lines.add(line);
              }
              lines.stream().flatMap(l -> Stream.of(l.split("\\PL+"))).collect(Collectors.toMap(Function.identity(), w -> 1, Integer::sum)).forEach((k,v) -> System.out.println(k + "\t" + v));} catch (IOException e) {
            e.printStackTrace();
          }
      }
}
