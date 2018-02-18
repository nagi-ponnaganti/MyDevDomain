package com.nagihome.ocp.ch05;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatNumbers {

    public static void main(String args[]) throws ParseException {

        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        System.out.println("German Number: " + NumberFormat.getInstance(Locale.GERMAN).format(attendeesPerMonth));
        System.out.println("US Number: " + NumberFormat.getInstance(Locale.US).format(attendeesPerMonth));
        System.out.println("France Number: " + NumberFormat.getInstance(Locale.FRANCE).format(attendeesPerMonth));

        double price = 48;
        NumberFormat us = NumberFormat.getCurrencyInstance();
        System.out.println(us.format(price));

        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);

        String s = "40.45";
        System.out.println(en.parse(s)); // 40.45
        System.out.println(fr.parse(s)); // 40

        String amt = "£92,8776576676777777777777778777555555555556707.99";
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        double value = (Double) cf.parse(amt);
        System.out.println(value); // 92807.99

    }

}
