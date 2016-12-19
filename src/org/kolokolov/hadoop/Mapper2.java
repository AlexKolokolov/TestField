package org.kolokolov.hadoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.function.Function;
import java.io.IOException;

public class Mapper2 {
    public static void main(String[] args) {
        // put your code here
          try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
              String line;
              while ((line = reader.readLine()) != null) {
                  Map<String,Integer> map = Stream.of(line.split("\\PL+")).collect(Collectors.toMap(Function.identity(), w -> 1, Integer::sum));
                  map.forEach((k, v) -> System.out.println(k + "\t" + v));
              }
          } catch (IOException e) {
                e.printStackTrace();
          }
      }
}
