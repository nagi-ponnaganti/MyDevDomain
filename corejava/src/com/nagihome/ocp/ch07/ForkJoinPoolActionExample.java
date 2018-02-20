package com.nagihome.ocp.ch07;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;

public class ForkJoinPoolActionExample {

    public static void main(String[] args) {

        Double[] weights = new Double[10];
        int start = 0;
        int end = weights.length;
        ForkJoinTask<?> task = new WeightedAnimalAction(weights, start, end);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        Arrays.asList(weights).stream().forEach(i -> System.out.print(i + " "));

        weights = new Double[10];
        start = 0;
        end = weights.length;

        task = new WeightedAnimalTask(weights, start, end);
        pool = new ForkJoinPool();
        System.out.println("Fork Join Task: " + pool.invoke(task));

        Arrays.asList(weights).stream().forEach(i -> System.out.print(i + " "));

    }

}
