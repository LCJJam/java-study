package com.study.java.ch06;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ex05Deque {
    // 양방향 큐 (Double ended queue)
    public static void main(String[] args) {
        Deque<Integer> dque = new ArrayDeque<>();
        dque.addFirst(1); // [ 1 ]
        dque.addLast(2);  // [ 1 2 ]
        dque.addFirst(3); // [ 3 1 2 ]
        dque.addLast(4);  // [ 3 1 2 4 ]
        dque.offer(5);    // [ 3 1 2 4 5 ]
        while (!dque.isEmpty()){
            System.out.println(dque.pollLast());
        }
    }
}
