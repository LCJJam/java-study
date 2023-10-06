package com.study.java.ch05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex01List {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new LinkedList<>();

        long startTime = System.currentTimeMillis();

        for(int i =0; i < 100000 ; i++) {
            listA.add(0,i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();

        for(int i =0; i < 100000 ; i++) {
            listB.add(0,i);
        }
        System.out.println(System.currentTimeMillis() - startTime);


        for( Iterator<Integer> it = listB.iterator(); it.hasNext(); ){
            System.out.println(it.next());
        }

    }
}
