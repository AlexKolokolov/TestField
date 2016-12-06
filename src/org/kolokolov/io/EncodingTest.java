package org.kolokolov.io;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingTest {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString("A".getBytes("UTF-8")));
        System.out.println(Arrays.toString("ABC".getBytes("UTF-8")));
        System.out.println(Arrays.toString("A".getBytes("UTF-16")));
        System.out.println(Arrays.toString("ABC".getBytes("UTF-16")));
        System.out.println(Arrays.toString("АБВ".getBytes("UTF-8")));
        System.out.println(Arrays.toString("АБВ".getBytes("UTF-16")));
        System.out.println(Arrays.toString("A".getBytes(StandardCharsets.UTF_8)));
        System.out.println(Arrays.toString("ABC".getBytes(StandardCharsets.UTF_8)));
        System.out.println(Arrays.toString("A".getBytes(StandardCharsets.UTF_16)));
        System.out.println(Arrays.toString("ABC".getBytes(StandardCharsets.UTF_16)));
        System.out.println(Arrays.toString("АБВ".getBytes(StandardCharsets.UTF_16)));
        System.out.println(Arrays.toString("АБВ".getBytes(StandardCharsets.UTF_16)));
    }
}
