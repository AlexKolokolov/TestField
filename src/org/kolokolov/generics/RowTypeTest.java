package org.kolokolov.generics;

import java.util.ArrayList;
import java.util.List;

public class RowTypeTest {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add(1);
        int i = (Integer) list.get(0);
        System.out.println(i);
    }
}
