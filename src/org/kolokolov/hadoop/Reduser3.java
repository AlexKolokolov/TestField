package org.kolokolov.hadoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Reduser3 {
    public static void main(String[] args) {
        // put your code here
          try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
              List<String> outLines = new ArrayList<>();
              String line;
              String previousLine = "";
              while (!(line = reader.readLine()).isEmpty()) {
                  String[] data = line.split("\\W");
                  String[] previousData = previousLine.split("\\W");
                  if (data[0].equals(previousData[0])) {
                      outLines.add(data[0] + "#" + data[1] + "\t" + data[2] + "\t"  );
                  } else if (previousData != null) {
                      outLines.forEach(l -> System.out.println(l + outLines.size()));
                      outLines.clear();
                      outLines.add(data[0] + "#" + data[1] + "\t" + data[2] + "\t");
                  }
                  previousLine = line;
              }
              outLines.forEach(l -> System.out.println(l + outLines.size()));
          } catch (IOException e) {
            e.printStackTrace();  
          }
      }

}
