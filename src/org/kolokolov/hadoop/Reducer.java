package org.kolokolov.hadoop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Reducer {
    public static void main(String[] args) {
        // put your code here
          try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
              Map<String,Integer> total = new LinkedHashMap<>();
              Map<String,Integer> number = new HashMap<>();
              String line;
              while (!(line = reader.readLine()).isEmpty()) {
                  String[] pair = line.split("[\t;]");
                  total.merge(pair[0], Integer.parseInt(pair[1]), Integer::sum);
                  number.merge(pair[0], Integer.parseInt(pair[2]), Integer::sum);
              }
              total.forEach((k,v) -> {
                  int n = number.get(k); 
                  System.out.println(k + "\t" + v + ";" + n);
              });
          } catch (IOException e) {
            e.printStackTrace();
          }
      }
}
