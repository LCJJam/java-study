package com.study.java.ch06;

import java.util.Stack;

public class Ex04Stack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(2);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
