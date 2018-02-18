package com.nagihome.ocp.ch05;

import java.util.Locale;

public class StringLiteralOps {

    public static void main(String[] args) {

        String s1 = "bunny";
        String s2 = "bunny";
        String s3 = new String("bunny");

        System.out.println("Strings Literals Compared: " + s1 == s2);
        System.out.println("String Literal Object Compared 01: " + s1 == s3);
        System.out.println("String Literal Object Compared 02: " + s1.equals(s3));

        String s4 = "abcde ";
        System.out.println("trim length: " + s4.trim().length());
        System.out.println("charAt: " + s4.charAt(4));
        System.out.println("Index Of Char: " + s4.indexOf('c'));
        System.out.println("Index Of Char: " + s4.indexOf("de"));
        System.out.println("SubString: " + s4.substring(4, 6));
        System.out.println("replace: " + s4.replace('a', '1'));
        System.out.println("contains: " + s4.contains("DE"));
        System.out.println("startswith: " + s4.startsWith("ab"));
        System.out.println(new StringBuilder(1).append(123).toString());

        Locale locale = Locale.getDefault();
        System.out.println("My Locale: " + locale);
        System.out.println("German Locale 01: " + Locale.GERMAN);
        System.out.println("German Locale 02: " + Locale.GERMANY);

        System.out.println("French Locale: " + new Locale("fr"));
        System.out.println("Indian Locale: " + new Locale("hi", "IN"));


//        test((short)'A');
    }

    private static void test(int i) {
        System.out.println("input: " + i);
    }
}
