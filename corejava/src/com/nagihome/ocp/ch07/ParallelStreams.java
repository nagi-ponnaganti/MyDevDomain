package com.nagihome.ocp.ch07;

import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String args[]) {

        IntStream.range(0, 5).forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.range(0, 5).parallel().forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.range(0, 5).parallel().forEachOrdered(i -> System.out.print(i + " "));

        long before, after;
        System.out.println();
        before = System.nanoTime();
        IntStream.range(0, 5).sum();
        after = System.nanoTime();

        System.out.println("serial stream time : " + (after - before));

        before = System.nanoTime();
        IntStream.range(0, 5).parallel().sum();
        after = System.nanoTime();

        System.out.println("serial stream time : " + (after - before));

    }

}
