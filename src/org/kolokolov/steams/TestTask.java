package org.kolokolov.steams;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestTask {
    
    public static List<Integer> createRandomList(int size) {
        List<Integer> list = new Random().ints(50, 150).limit(size / 2).boxed().collect(Collectors.toList());
        list.addAll(list);
        list.remove(list.size() - 1);
        Collections.shuffle(list);
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
