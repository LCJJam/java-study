package com.study.java.ch03;

public class Ex04StringBuffer {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "abcdef";
        // 문자열을 합칠 때 마다, 인스턴스를 새로 생성하게 되어 성능의 문제가 발생함.
        String s3 = s1 + s2 ;

        System.out.println(s3);

        // 멀티 스레드 환경에 병렬작업에 좋음
        StringBuffer sbf1 = new StringBuffer("abcdef");
        sbf1.append("abcdef");
        String s4 = sbf1.toString();
        System.out.println(s4);

        // 단일 작업에 좋음
        StringBuilder sbd1 = new StringBuilder("abcdef");
        sbd1.append("abcdef");
        String s5 = sbd1.toString();
        System.out.println(sbd1);


        // Speed Test   -   sbd > sbf > s
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++){
            s1+="a";
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime); // 5365


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++){
            sbf1.append("a");
        }
        endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime); // 2


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++){
            sbd1.append("a");
        }
        endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime); // 0


    }
}
