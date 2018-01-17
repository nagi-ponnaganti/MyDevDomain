package com.nagihome.ej.ch02;

public class Item06 {

    public static void main(String[] args) {

        String s1 = "NewString";
        String s2 = "NewString";
        String s3 = new String("NewString");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));

        System.out.println("sum01: " + sum01());
//        System.out.println("sum02: " + sum02());

    }

    private static long sum01() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;

        return sum;
    }

    private static long sum02() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;

        return sum;
    }

}
