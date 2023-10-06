package com.study.java.ch07;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04Stream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b" , "c");
        stream.forEach(str -> System.out.print(str + ", "));
        System.out.println();

        Stream<Integer> lottoStream = Stream.generate(() -> (int)(Math.random() * 45) + 1).limit(6);
        lottoStream.forEach( str -> System.out.print(str + ", "));

        System.out.println();
        Stream
                .iterate(1, i -> i+1)
                .limit(45)
                .forEach(i -> System.out.print(i + ","));

        System.out.println();
        IntStream intStream = new Random()
                .ints(1, 45)
                .limit(6);
        intStream.forEach(System.out::println);

        System.out.println();
        Optional<Integer> a = Stream
//        Stream
                .iterate(1, i -> i+1)
                .limit(45)
                .filter(b -> b < 30)
                .findAny();
//                .forEach(i -> System.out.print(i + ","));
        a.ifPresent(System.out::println);


    }
}
