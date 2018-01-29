package com.nagihome.java8.funinter;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {

    public static void main(String[] args) {

        System.out.printf("Add and then Multiply: %s\n", add.andThen(multiplyByOwn).apply(3, 1));
    }

    private static final BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    private static final Function<Integer, Integer> multiplyByOwn = (n) -> n * n;

}
