package org.kolokolov.interview;

import java.util.Map;
import java.util.TreeMap;

/*
* The task is to create method that takes a string
* and counts unique characters in it.
* So if input string is "aaabcaaabc" output should 
* be "6a2b2c"
*/
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
}
