package org.kolokolov.strings;

import java.util.Arrays;

public class StringSplitTest {
    public static void main(String[] args) {
        String str = "aaa.bbb\tccc;ddd";
        String[] arr = str.split("[\t;]");
        
        System.out.println(str);
        System.out.println(Arrays.toString(arr));
        
        String str2 = "aaa bbb, ccc:qqq_www";
        String[] arr2 = str2.split("[\\W_]+");
        
        System.out.println(str2);
        System.out.println(Arrays.toString(arr2));

    }
}
