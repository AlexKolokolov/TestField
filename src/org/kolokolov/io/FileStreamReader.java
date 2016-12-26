package org.kolokolov.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStreamReader {
    public static void main(String[] args) {
        String fileName = "test/hadoopTest.txt";
        printWordsFromFile(fileName);
        System.out.println(countDistinctWordsInFile(fileName));
        System.out.println(countAndSortDistinctWordsInFile(fileName));
        printMapSorted(countDistinctWordsInFile(fileName));
    }
    
    static void printWordsFromFile(String fileName) {
        try (Stream<String> lines = Files.lines(FileSystems.getDefault().getPath(fileName))) {
            lines.flatMap(l -> Stream.of(l.split(" "))).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static Map<String,Integer> countDistinctWordsInFile(String fileName) {
        Map<String,Integer> result = null;
        try (Stream<String> lines = new BufferedReader(new FileReader(fileName)).lines()) {
            result = lines.flatMap(l -> Stream.of(l.split(" "))).collect(Collectors.toMap(Function.identity(), word -> 1, Integer::sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    static Map<String,Integer> countAndSortDistinctWordsInFile(String fileName) {
        return countDistinctWordsInFile(fileName).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
    }
    
    static <K,V extends Comparable<V>> void printMapSorted(Map<K,V> map) {
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
