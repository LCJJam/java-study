package com.study.java.ch03;

import java.util.Objects;

public class Ex01Object {
    public static void main(String[] args) {

        Book book1 = new Book("제목1","저자1",3);
        Book book2 = new Book("제목1","저자1",3);

        System.out.println(book1 == book2); // false
        System.out.println(book1.equals(book2)); // true

        // 재정의 한 Hash Code는 같다.
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());

        // 실제로는 다름
        System.out.println(System.identityHashCode(book1));
        System.out.println(System.identityHashCode(book2));

    }
}

class Book {
    private String title;
    private String author;
    private int edition;

    public Book (String title, String author, int edition) {
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    // Equals 메소드 커스텀
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Book)) {
            return false;
        }

        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author) && edition == book.edition;
    }

    // HashCode 메소드 커스텀
    @Override
    public int hashCode(){
        return Objects.hash(title, author);
    }

}