package org.kolokolov.strings;

public class StringParsingTest {
    public static void main(String[] args) {
        String str = "250m";

        int factor = 1;
        if (str.endsWith("k"))
            factor = 1024;
        if (str.endsWith("m"))
            factor = 1024 * 1024;
        int i = Integer.parseInt(str.split("\\D")[0]) * factor;
        System.out.println(i);
    }
}
