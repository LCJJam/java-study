package com.study.java.ch07;

import java.util.function.*;

public class Ex01FunctionalInterface {
    public static void main(String[] args) {
        Supplier<Integer> as = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random() * 10);
            }
        };
        System.out.println(as.get());

        // 추상 메서드가 하나인 것만 , 람다식으로 구현 가능

        // 파라미터가 필요 없는 것
        Supplier<Integer> s = () -> (int)(Math.random() * 10);
        System.out.println(s.get());

        // 파라미터만 받고, 리턴하지 않는 것
        Consumer<Integer> c = i -> System.out.println(i);
        c.accept(7);

        // 함수형  < param , return >
        Function<Integer, Double> f = i -> i/2.0;
        System.out.println(f.apply(5));

        // Boolean
        Predicate<Integer> p = i -> i == 22;
        System.out.println(p.test(23));
        Predicate<Integer> p1 = i -> i < 10;
        Predicate<Integer> p2 = i -> i < 30;
        Predicate<Integer> p3 = p.or(p1.negate().and(p2));
        System.out.println(p3.test(22));
        System.out.println(p3.test(20));

        // Param : 1, return 이 존재
        // Param 과 return  Type이 같을 때,
        UnaryOperator<Integer> u = i -> i*10;
        System.out.println(u.apply(7));

        // Bi : Param 이 두개
        BiConsumer<String, Integer> bc = (str, i) -> System.out.println(str + ":" + i);
        BiConsumer<String, Integer> bc2 = (str, i) -> System.out.println(str + "*10:" + (i*10));
        bc.andThen(bc2).accept("A",8);

    }
}
