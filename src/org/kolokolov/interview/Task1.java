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
        str.codePoints().mapToObj(codePoint -> (char) codePoint).forEach(ch -> chars.merge(ch, 1, Integer::sum));
// Next line is an another working example
//        str.codePoints().mapToObj(codePoint -> (char) codePoint)
//                .forEach(ch -> chars.put(ch, chars.getOrDefault(ch, 1) + 1));

        StringBuilder result = new StringBuilder();
        chars.forEach((k,v) -> result.append(v).append(k));

// Next line is an another working example       
//        chars.entrySet().forEach(entry -> result.append(entry.getValue()).append(entry.getKey()));
        return result.toString();
    }
}
