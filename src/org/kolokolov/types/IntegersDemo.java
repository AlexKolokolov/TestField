package org.kolokolov.types;

public class IntegersDemo {
    public static void main(String[] args) {
        int i1 = 260;
        byte b1 = (byte) i1;
        System.out.println(b1);

        System.out.println(~30000);

        int sum = 0;
        for (int j = 1; j <= 100; j++) {
            sum += j;
        }
        System.out.println(sum);
    }
}
