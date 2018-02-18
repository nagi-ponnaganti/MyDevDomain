package com.nagihome.ocp.ch05;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class ZooOpen {

    public static void main(String[] args) {

        Locale fr = new Locale("fr", "FR");
        Locale en = new Locale("en", "US");

        printProperties(fr);
        printProperties(en);

        ResourceBundle rb = ResourceBundle.getBundle("Zoo", new Locale("fr", "FR"));
        Set<String> keys = rb.keySet();
        keys.stream().map(k -> " Key: " + k + " Value: " + rb.getString(k)).forEach(System.out::println);

    }

    private static void printProperties(Locale locale) {
        ResourceBundle res = ResourceBundle.getBundle("Zoo", locale);
        System.out.printf("Hello in %s is %s \n", locale.getLanguage(), res.getString("hello"));
        System.out.printf("Open in %s is %s \n", locale.getLanguage(), res.getString("open"));

    }
}
