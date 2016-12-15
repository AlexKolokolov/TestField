package org.kolokolov.interview;

import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* The task is to create method that takes a string
* and counts unique characters in it.
* So if input string is "aaabcaaabc" output should 
* be "6a2b2c"
*/
public class Task1v2 {

    public static String countLetters(String str) { 
        StringBuilder result = new StringBuilder();
        str.codePoints().mapToObj(cp -> (char) cp)
                .collect(Collectors.toMap(Function.identity(), cp -> 1, Integer::sum, TreeMap::new))
                .forEach((k, v) -> result.append(v).append(k));
        return result.toString();
    }
}
