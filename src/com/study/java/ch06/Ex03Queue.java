package com.study.java.ch06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Ex03Queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        // 멀티쓰레드 시, 안전한 동기화 제공
        Queue<Integer> queue1 = new ConcurrentLinkedQueue<>();

    }
}
