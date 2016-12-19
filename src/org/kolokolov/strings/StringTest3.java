package org.kolokolov.strings;

public class StringTest3 {
    public static void main(String[] args) {
        String str = "12345";
        System.out.println(str.substring(0, str.length() - 1));
        
        StringBuilder strBuider = new StringBuilder("12345");
        System.out.println(strBuider.substring(0,strBuider.length() - 1));
        
    }
}
