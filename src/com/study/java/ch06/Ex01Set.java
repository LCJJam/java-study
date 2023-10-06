package com.study.java.ch06;

import java.util.*;

public class Ex01Set {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("기3");
        list.add("4억");
        list.add("이5");
        list.add("2난");
        list.add("다1");

        Set<String> strSet = new HashSet<>(list);

        for(String i : strSet) {
            System.out.print(i + ", ") ;
        }

        System.out.println();

        List<String> sortedList = new ArrayList<>(strSet);
        Collections.sort(sortedList,Collections.reverseOrder());
        for(String i : sortedList) {
            System.out.print(i + ", ");
        }

    }
}
