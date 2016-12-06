package org.kolokolov.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    
    public static void main(String[] args) {
        System.out.println(getWinningNumbers(6, 49));
        System.out.println(getWinningNumbers2(6, 49));
    }
    
    
    public static Collection<Integer> getWinningNumbers(int winningNumbers, int totalNumers) {
        if (winningNumbers < 0 || totalNumers < 0 || winningNumbers > totalNumers) 
            throw new IllegalArgumentException();
        
        List<Integer> numbers = IntStream.range(1, totalNumers + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.subList(0, winningNumbers);
    }
    
    public static Collection<Integer> getWinningNumbers2(int winningNumbers, int totalNumers) {
        if (winningNumbers < 0 || totalNumers < 0 || winningNumbers > totalNumers) 
            throw new IllegalArgumentException();
        Random rnd = new Random();
        
        Set<Integer> result = new HashSet<>();
        
        while (result.size() < winningNumbers) {
            result.add(rnd.nextInt(totalNumers) + 1);
        }
        return result;
    }
    
    
}
