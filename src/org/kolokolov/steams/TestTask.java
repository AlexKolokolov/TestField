package org.kolokolov.steams;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTask {
    
    public static List<Integer> createRandomList(int size) {
        Random rnd = new Random();
        List<Integer> list = Stream.generate(() -> rnd.nextInt(100)).limit(size / 2).collect(Collectors.toList());
        list.addAll(list);
        Collections.shuffle(list);
        list.remove(list.size() - 1);
        return list;
    }
    
    public static int findAloneInt(List<Integer> list) {
        return list.stream().reduce(0, (result, nextElement) -> result ^ nextElement);
    }
    
    public static void main(String[] args) {
        List<Integer> list = createRandomList(21);
        System.out.println(list);
        System.out.println(findAloneInt(list));
    }
}
