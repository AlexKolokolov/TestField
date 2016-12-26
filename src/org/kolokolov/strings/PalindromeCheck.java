package org.kolokolov.strings;

public class PalindromeCheck {
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("asddsa"));
        System.out.println(isPalindrome("asdadsa"));
        System.out.println(isPalindrome("asddsaa"));
    }
    
    static boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }

}
