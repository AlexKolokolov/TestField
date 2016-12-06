package org.kolokolov.innerclass;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTask {
    
    public static void main(String[] args) {
        Random rnd = new Random();
        List<Point> pointList = Stream.generate(() -> new Point(rnd.nextInt(50), rnd.nextInt(50)))
                .limit(10).collect(Collectors.toList());
        System.out.println("Initial points : " + pointList);
        pointList.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        System.out.println("Sorted points : " + pointList);
        
        List<Point> pointList2 = Stream.generate(Point::new).limit(10).collect(Collectors.toList());
        System.out.println("Initial points : " + pointList2);
        pointList2.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        System.out.println("Sorted points : " + pointList2);
    }

    private static class Point {
        private static final Random RND = new Random();
        private int x;
        private int y;
        
        public Point() {
            this(RND.nextInt(50), RND.nextInt(50));
        }
        
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
}
