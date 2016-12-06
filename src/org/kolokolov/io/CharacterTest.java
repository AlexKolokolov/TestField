package org.kolokolov.io;

public class CharacterTest {
    public static void main(String[] args) {
        char[] chars = Character.toChars(80_000);
        System.out.println(chars.length);
        System.out.println(chars);
//        System.out.println(chars[0]);
//        System.out.println(chars[1]);
    }
}
