package com.study.java.ch01;

public class Ex01Enum {
    public static void main(String[] args) {

        System.out.println(3 * Ex02Enum.UK.getRefundTax());

        Ex02Enum a = Ex02Enum.KOREA;

        System.out.println(a.getTax());
        System.out.println(a.getRefundTax());

    }
}