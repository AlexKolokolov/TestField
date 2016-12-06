package org.kolokolov.arrays;

import java.util.Map;
import java.util.TreeMap;

public class MepSumDemo {
    public static void main(String[] args) {
        
        String str = "qqQrRqqTtr";
        Map<Character,Integer> chars = new TreeMap<>();
        
        str.toLowerCase().codePoints().mapToObj(cp -> (char) cp).forEach(ch -> chars.merge(ch, 1, Integer::sum));
        
        System.out.println(chars);
        
        StringBuilder result = new StringBuilder();
        
        chars.forEach((ch, num) -> result.append(num).append(ch));
        
        System.out.println(result);
        
    }
    
    
}
