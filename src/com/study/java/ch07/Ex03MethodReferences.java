package com.study.java.ch07;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Ex03MethodReferences {
    public static void main(String[] args) {
        Function<String, Integer> f1 = str -> Integer.parseInt(str);
        int i1 = f1.apply("77");
        System.out.println(i1);

        Function<String, Integer> f2 = Integer::parseInt;
        int i2 = f1.apply("88");
        System.out.println(i2);

        System.out.println();

//        IntFunction<int[]> f3 = i -> new int[i];
        IntFunction<int[]> f3 = int[]::new;
        System.out.println(Arrays.toString(f3.apply(4)));

//        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer = st -> System.out.println(st);
        consumer.accept("pwd");



    }
}
