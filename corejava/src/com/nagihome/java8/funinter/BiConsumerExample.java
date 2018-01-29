package com.nagihome.java8.funinter;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        add.andThen(sub).accept(3, 2);
    }

    private static final BiConsumer<Integer, Integer> add = (a, b) -> System.out.printf("a+b: %s\n", (a + b));
    private static final BiConsumer<Integer, Integer> sub = (a, b) -> System.out.printf("a-b: %s\n", (a - b));

}
