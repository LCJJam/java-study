package com.study.java.ch02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01Exception {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // multiple catch block
        // docs : https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html

        try {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println(i/j);
            method1();

        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("산술 예외 발생");
            e.printStackTrace();
        }  catch (Exception e) {
            System.out.println("예외 발생");
            e.printStackTrace();
        }

    }

    public static void method1() throws ClassNotFoundException{
        Class clazz = Class.forName("java.lang.String2");
    }
}
