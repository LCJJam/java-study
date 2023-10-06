package com.study.java.ch06;


import java.util.*;

public class Ex06TreeSet {
    public static void main(String[] args) {
        NavigableSet<Integer> tSet = new TreeSet<>();
        tSet.add(300);
        tSet.add(700);
        tSet.add(100);
        tSet.add(200);
        tSet.add(200);
        tSet.add(900);
        tSet.add(800);
        tSet.add(550);
        
        for(Iterator<Integer> it = tSet.iterator(); it.hasNext(); ){
            System.out.println(it.next() + "원");
        }

        Set<Integer> revTSet = tSet.descendingSet();

        for(Iterator<Integer> it = revTSet.iterator(); it.hasNext(); ){
            System.out.println(it.next() + "원");
        }

        SortedSet<Integer> sortedHeadSet = tSet.headSet(200);
        System.out.println(sortedHeadSet);

        SortedSet<Integer> sortedTailSet = tSet.tailSet(200);
        System.out.println(sortedTailSet);

        System.out.println(tSet.higher(200));

        NavigableSet<Integer> subTSet = tSet.subSet(200,true,700, false);
        System.out.println(subTSet);
    }
}
