package org.kolokolov.lambdas;

public class StringModifierDemo {
    
    public static String modifyStr(String str, StringModifier modifier) {
        return modifier.modify(str);
    }
    
    public static boolean analizeStr(String str, StringAnalizer analizer) {
        return analizer.analize(str);
    }
    
    public static void main(String[] args) {
        String str1 = "qwe rty uio";
        String result1 = modifyStr(str1, s -> s.replaceAll(" ", "_"));
        System.out.println(str1 + " -> " + result1);
        
        StringModifier reverse = s -> new StringBuilder(s).reverse().toString();
        
        String str2 = "qwerty";
        String result2 = modifyStr(str2, reverse);
        System.out.println(str2 + " -> " + result2);        
        
        
        StringAnalizer isPalindrome = s -> new StringBuilder(s).reverse().toString().equalsIgnoreCase(s);
        
        String str3 = "asdddsa1";
        boolean result3 = analizeStr(str3, isPalindrome);
        System.out.println(str3 + (result3 ? " is palindrome" : " is not palindrome"));
        
    }
}
