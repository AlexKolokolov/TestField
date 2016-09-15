package org.kolokolov.interview;

import java.util.Map;
import java.util.TreeMap;

public class Task1 {
    
    public static String countLetters(String str) {
        
        Map<Character, Integer> chars = new TreeMap<>();
        str.chars().forEach(ch -> {
                Integer number = chars.get((char) ch);
                if (number == null) number = 0;
                chars.put((char) ch, number + 1);
            });
        
        StringBuilder result = new StringBuilder();
        chars.entrySet().stream().forEach(entry -> result.append(entry.getValue()).append(entry.getKey()));
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(countLetters("zzkkqqqaaabcaaabc"));
    }
}
