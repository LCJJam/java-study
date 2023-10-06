package com.study.java.ch07;

import java.util.*;

public class Ex05Reduction {
    public static void main(String[] args) {
        List<EBook> eBooks = new ArrayList<>();
        eBooks.add(new EBook("자바 기본", 50000, EBook.Category.LANG));
        eBooks.add(new EBook("자바 알고리즘", 50000, EBook.Category.APP));
        eBooks.add(new EBook("파이썬 기본", 33000, EBook.Category.LANG));
        eBooks.add(new EBook("파이썬 기본", 35000, EBook.Category.LANG));
        eBooks.add(new EBook("파이썬 기본", 35000, EBook.Category.LANG));
        eBooks.add(new EBook("리늑스", 40000, EBook.Category.APP));

        double avgPrice =
                eBooks
                        .stream()
                        .filter(b -> b.getCategory().equals(EBook.Category.LANG))
                        .mapToInt(EBook::getPrice)
                        .average()
                        .getAsDouble();
        System.out.printf("%,.0f원%n", avgPrice);
        System.out.println();

        int sumPrice =
                eBooks
                        .stream()
                        .mapToInt(EBook::getPrice)
                        .sum();
        System.out.printf("%,d원%n", sumPrice);

        EBook maxEBook =
                eBooks
                        .stream()
                        .reduce((a,b) -> a.getPrice() > b.getPrice() ? a : b)
                        .get();
        System.out.println(maxEBook);
        System.out.println();

        Set<Integer> priceSet =
                eBooks
                        .stream()
                        .map(EBook::getPrice)
                        .collect(
                                () -> new HashSet<>(),  // Supplier
                                (set, i) -> set.add(i),  // Accumulator
                                (set1, set2) -> set1.addAll(set2)); // Combiner
        //              .collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println(priceSet);

    }
}

class EBook {
    public enum Category {
        LANG, APP,
    }

    private String title;
    private int price;
    private Category category;

    public EBook(String title, int price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle(){
        return title;
    }

    public int getPrice(){
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString(){
        return "title : " +title+ ", price : "+price+ ", Category : "+category;
    }
}
