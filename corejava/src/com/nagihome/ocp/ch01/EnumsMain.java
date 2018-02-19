package com.nagihome.ocp.ch01;

import java.util.stream.Stream;

public class EnumsMain {


    public static void main (String[] args) {

        Season s = Season.SUMMER;
        System.out.println(s);
        System.out.println(s == Season.SUMMER);

        Stream.of(Season.values()).forEach(e -> System.out.println(e.name() + " is an enum with ordinal: " + e.ordinal()));
    }

    private enum Season {
        SUMMER, WINTER, SPRING, FALL
    }
}
