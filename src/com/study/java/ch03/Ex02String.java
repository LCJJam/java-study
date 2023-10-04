package com.study.java.ch03;

public class Ex02String {
    public static void main(String[] args) {
        String s1 = "스트링";
        String s2 = "스트링";

        // 메모리 효율적인 사용을 위한 문자열 Pool 에서 가져와 사용
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        String s3 = new String("스트링");
        String s4 = new String("스트링");

        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));

        System.out.println(System.identityHashCode(s3.intern())); // 문자열 Pool 에서 가져옴

        String s0 = "안, 녕, 하, 세, 요, ?";
        String target = ",";
        int pos = 0;
        int count = 0;

        while ( ( pos = s0.indexOf(target , pos)) != -1) {
            pos += target.length();
            count++;
        }
        System.out.println(count);


    }
}
