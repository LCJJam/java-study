package com.study.java.ch05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02Generics {
    public static void main(String[] args) {
        Numbers list = new Numbers();
        list.add(1);
        list.add(2);
        list.printAllItems();
        System.out.println(list.get(0));

    }
}

class Numbers<T> {
    private List<T> items;

    public Numbers() {
        items = new ArrayList<>();
    }

    public Numbers(T[] arr) {
        items = new ArrayList<>(Arrays.asList(arr));
    }

    public void add(T item) {
        items.add(item);
    }

    public T get (int index) {
        return items.get(index);
    }

    public void printAllItems() {
        for(T item : items) {
            System.out.println(item);
        }
    }
}