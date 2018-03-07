package com.nagihome.jn.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibonacciSeries {

    private static List<Integer> fibSeries = new ArrayList<>();

    static {
        fibSeries.add(0);
        fibSeries.add(1);
    }

    public static void main(String[] args) {

        System.out.println("FibonacciSeries: " +
                getFibSeries(12)
                        .stream()
                        .map(i -> String.valueOf(i))
                        .collect(Collectors.joining(",")));

    }

    public static List<Integer> getFibSeries(int times) {

        IntStream.rangeClosed(0, times).forEach(
                i -> {
                    fibSeries.add(i + 2, fibSeries.get(i) + fibSeries.get(i + 1));
                }

        );

        return fibSeries;
    }
}
