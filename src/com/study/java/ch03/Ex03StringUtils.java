package com.study.java.ch03;

import java.util.Arrays;

public class Ex03StringUtils {
    public static void main(String[] args) {
        String s1 = "스트링";
        String s2 = "스트링";
        System.out.println(s1.compareTo(s2)); // 0
        s2 = "가나다";
        System.out.println(s1.compareTo(s2)); // 양수
        s2 = "아자차";
        System.out.println(s1.compareTo(s2)); // 음수

        String s0 = "Default Example";
        int i = 393922200;
        double fl = 2.717234;

        System.out.println(String.format("%20s",s0));
        System.out.println(String.format("%,d",i));
        System.out.println(String.format("%#11.3f",fl));
        System.out.println(String.format("%011.3f",fl));


        String trimTest = "  1 2  34 9 5  6   8  9  10  23   29  ";
        System.out.println(trimTest);
        System.out.println(trimTest.trim());

        String[] strArr = trimTest.split(" ");
        System.out.println(Arrays.toString(strArr));

        String[] strArr2 = trimTest.split(" +");
        System.out.println(Arrays.toString(strArr2));

        String[] strArr3 = trimTest.split(" +",3);
        System.out.println(Arrays.toString(strArr3));

        String allAlpha = "abpld";
        String allNumber = "23125";
        System.out.println(allAlpha.matches("[a-z]"));
        System.out.println(allAlpha.matches("[a-z]+"));
        System.out.println(allNumber.matches("[0-9]"));
        System.out.println(allNumber.matches("[0-9]+"));

        System.out.println(trimTest.matches("[0-9a-z\\s]+"));

    }
}
