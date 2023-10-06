package com.study.java.ch04;

public class Ex01Wrapper {
    public static void main(String[] args) {

        String strNum = "3.14";
        System.out.println(strNum + 0.01);
        System.out.println(Double.parseDouble(strNum) + 0.01);
        System.out.println();

        Double objPi = Double.valueOf(3.14);
        double Pi = objPi.doubleValue();
        System.out.println(Pi);

        // 오토 박싱 -> 기본형을 참조형으로 자동으로 변환하여 계산을 편리하게 해줌.
        // 오토 언박싱 -> 참조형을 기본형으로 자동으로 변환하여 계산을 편리하게 해줌.

        Integer a = Integer.valueOf(3);

        System.out.println(a.intValue());

    }
}
