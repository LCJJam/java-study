package com.study.java.ch06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex09Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "A","D","B","C","E");

        System.out.println(Collections.binarySearch(list,"D"));
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list,"D"));
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
        System.out.println(Collections.replaceAll(list,"C","J"));
        System.out.println(Collections.replaceAll(list,"Z","J"));
        System.out.println(list);

        /*
            -5
            3
            [A, B, C, D, E]
            [E, D, C, B, A]
            true
            false
            [E, D, J, B, A]
         */
    }
}
