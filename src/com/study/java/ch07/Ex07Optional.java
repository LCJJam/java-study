package com.study.java.ch07;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Ex07Optional {
    public static void main(String[] args) {
        List<EBook> eBooks = new ArrayList<>();
        eBooks.add(new EBook("자바 기본", 50000, EBook.Category.LANG));
        eBooks.add(new EBook("자바 알고리즘", 50000, EBook.Category.APP));
        eBooks.add(new EBook("파이썬 기본", 33000, EBook.Category.LANG));
        eBooks.add(new EBook("파이썬 기본", 35000, EBook.Category.LANG));
        eBooks.add(new EBook("파이썬 기본", 35000, EBook.Category.LANG));
        eBooks.add(new EBook("리늑스", 40000, EBook.Category.APP));

        EBook eb = new EBook("AWS" , 40000 , EBook.Category.APP);
        Optional<EBook> opt = Optional.of(eb);
        System.out.println(opt.get());
        System.out.println();

        EBook eb2 = null;
        try {
            Optional<EBook> opt2 = Optional.of(eb2);
            System.out.println(opt2.get());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생");
        }
        System.out.println();

        Optional<EBook> opt3 = Optional.ofNullable(eb2);
        if(opt3.isPresent()) {
            System.out.println(opt3.get());
        } else {
            System.out.println("Null 입니다.");
        }
        System.out.println();

        EBook eb3 = opt3.isPresent() ? opt3.get() : new EBook("옵셔널",30000, EBook.Category.LANG);
        // EBook eb3 = opt3.orElseGet(() -> new EBook("옵셔널", 30000, EBook.Category.LANG));
        System.out.println(eb3);
        System.out.println();

        Optional<EBook> opt4 = Optional.empty(); // 인스턴스이기 때문에, 빈 값을 정의하고싶다면 empty를 사용한다.
        Optional<EBook> opt5 = null;  // NullPointerException 발생

        OptionalInt optInt =
                eBooks
                        .stream()
                        .mapToInt(EBook::getPrice)
                        .max();
        System.out.println(optInt.getAsInt());

    }
}
