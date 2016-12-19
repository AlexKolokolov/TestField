package org.kolokolov.steams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordsCounter {

    public static void main(String[] args) {
        WordsCounter wordsCounter = new WordsCounter();
        String fileContent = null;
        try {
            fileContent = wordsCounter.readFile("./test/Shakespeare/THE TRAGEDY OF HAMLET, PRINCE OF DENMARK.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> words = wordsCounter.countWorgs(fileContent);
        wordsCounter.printMostFriquentWords(words, 100);
    }

    public String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public Map<String, Integer> countWorgs(String str) {
        Map<String, Integer> words = new HashMap<>();
        Stream.of(str.split("\\PL+")).filter(word -> word.length() > 3).map(String::toLowerCase)
                .forEach(word -> words.merge(word, 1, Integer::sum));
        return words;
    }

    public void printMostFriquentWords(Map<String, Integer> words, int number) {
        words.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .limit(number).forEach(System.out::println);
    }
}
