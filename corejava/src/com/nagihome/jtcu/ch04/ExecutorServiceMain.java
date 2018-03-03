package com.nagihome.jtcu.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.nagihome.jtcu.util.ThreadUtil.*;

public class ExecutorServiceMain {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();

        AtomicInteger counter = new AtomicInteger(0);

        es.submit(() -> {
            sleepForInMillis(1000);
            printThreadName();
        });

        Callable<Integer> r1 = counter::incrementAndGet;

        System.out.println("Expected Value: " + IntStream.rangeClosed(0, 10000).sum());
        List<Callable<Integer>> tasks = new ArrayList<>();
        IntStream.range(0, 10000).forEach(i -> tasks.add(r1));
        List<Future<Integer>> results = es.invokeAll(tasks);

        System.out.println("Reduced Value: " +
                results.stream().map(f -> {
                    Integer i = null;
                    try {
                        i = f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    return i;
                }).reduce(0, (a, b) -> a + b));

        System.out.println("Shutting Down");
        es.shutdown();

        System.out.println("Await Termination: " + es.awaitTermination(5, TimeUnit.SECONDS));
        System.out.println("Exiting");
    }

}
