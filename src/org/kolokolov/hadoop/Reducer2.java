package org.kolokolov.hadoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reducer2 {
    public static void main(String[] args) {
        // put your code here
          try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
              List<String> queries = new ArrayList<>();
              List<String> urls = new ArrayList<>();
              String previousUser = null;
              String line;
              while (!(line = reader.readLine()).isEmpty()) {
                  String[] pair = line.split("[\t:]");
                  if (!pair[0].equals(previousUser)) {
                      printAndClear(previousUser, queries, urls);
                  }
                  if ("url".equals(pair[1])) {
                      urls.add(pair[2]);
                  } else {
                      queries.add(pair[2]);
                  }
                  previousUser = pair[0];
              }
              printAndClear(previousUser, queries, urls);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

    private static void printAndClear(String user, List<String> queries, List<String> urls) {
        for (String query : queries) {
            for (String url : urls) {
                System.out.println(user + "\t" + query + "\t" + url);
            }
        }
        queries.clear();
        urls.clear();
    }
}
