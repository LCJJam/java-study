package com.study.java.ch07;

import java.util.*;
import java.util.stream.Collectors;

public class Ex06Collectors {
    public static void main(String[] args) {
        List<EBook> eBooks = new ArrayList<>();
        eBooks.add(new EBook("자바 기본", 50000, EBook.Category.LANG));
        eBooks.add(new EBook("자바 알고리즘", 50000, EBook.Category.APP));
        eBooks.add(new EBook("파이썬 기본", 33000, EBook.Category.LANG));
        eBooks.add(new EBook("파이썬 기본", 35000, EBook.Category.LANG));
        eBooks.add(new EBook("파이썬 기본", 35000, EBook.Category.LANG));
        eBooks.add(new EBook("리늑스", 40000, EBook.Category.APP));

        List<String> ebTitle =
                eBooks
                        .stream()
                        .map(EBook::getTitle)
                        .collect(Collectors.toList());
        System.out.println(ebTitle);
        System.out.println();

        Map<EBook.Category, Optional<EBook>> ebMaxBy =
                eBooks
                        .stream()
                        .collect(
                                Collectors
                                        .groupingBy(
                                                EBook::getCategory,
                                                Collectors.maxBy(Comparator.comparingInt(EBook::getPrice))
                                        )
                        );
        ebMaxBy.forEach((k,v) -> System.out.println(k + "\n" + v.get()));

        Map<EBook.Category, EBook> ebMaxBy2 =
                eBooks
                        .stream()
                        .collect(
                                Collectors
                                        .groupingBy(
                                                EBook::getCategory,
                                                Collectors.collectingAndThen(
                                                    Collectors.maxBy(Comparator.comparingInt(EBook::getPrice)),
                                                    Optional::get
                                                )
                                        )
                        );
        ebMaxBy2.forEach((k,v) -> System.out.println(k + "\n" + v));
        System.out.println();

        Set<String> ebSet =
                eBooks
                        .stream()
                        .collect(Collectors.mapping(EBook::getTitle, Collectors.toSet()));
        System.out.println(ebSet);
        System.out.println();

        Map<EBook.Category , Integer> ebMap3 =
                eBooks
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        EBook::getCategory,
                                        Collectors.reducing(  // identity , mapper , operation
                                                0,
                                                EBook::getPrice,
                                                Integer::sum
                                        )
                                )
                        );

        System.out.println(ebMap3);
    }
}
