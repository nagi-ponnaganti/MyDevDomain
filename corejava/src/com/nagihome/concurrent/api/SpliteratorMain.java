package com.nagihome.concurrent.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;

public class SpliteratorMain {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        IntStream.rangeClosed(0, 10).forEach(i -> ints.add(i));

        Spliterator<Integer> spliterator = ints.spliterator();

        System.out.println("spliterator Characteristics: " + spliterator.characteristics());
        System.out.println("spliterator estimate size: " + spliterator.estimateSize());
//        spliterator.forEachRemaining(i -> System.out.print(i + ","));
//        spliterator.forEachRemaining(i -> System.out.print(i + ","));

//        Spliterator<Integer> s2 = spliterator.trySplit();
//
//        spliterator.forEachRemaining(i -> System.out.print(i + ","));
//        System.out.println();
//        s2.forEachRemaining(i -> System.out.print(i + ","));

        System.out.println("Size: " + spliterator.estimateSize());
        spliterator.tryAdvance(i -> System.out.print(i + ","));
    }

}
