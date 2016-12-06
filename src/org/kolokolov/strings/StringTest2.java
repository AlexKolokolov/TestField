package org.kolokolov.strings;

public class StringTest2 {
    public static void main(String[] args) {
        String s1 = "qqq";
        System.out.println(s1 == "qqq"); //true
        System.out.println(s1.equals("qqq")); //true
        
        String s2 = "qqq";
        String s3 = "qqq";
        System.out.println(s2 == s3); //true
        System.out.println(s2.equals(s3)); //true
        
        String s4 = new String("qqq");
        String s5 = new String("qqq");
        System.out.println(s4 == "qqq"); //false
        System.out.println(s5 == "qqq"); //false
        System.out.println(s4 == s5); //false
        System.out.println(s4.equals(s5)); //true
    }
}
