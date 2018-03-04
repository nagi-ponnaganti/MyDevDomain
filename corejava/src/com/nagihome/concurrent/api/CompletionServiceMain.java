package com.nagihome.concurrent.api;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static com.nagihome.concurrent.api.ThreadUtil.getThreadName;
import static com.nagihome.concurrent.api.ThreadUtil.sleepForInMillis;

public class CompletionServiceMain {

    public static void main(String[] args) {
        Callable<String> r1 = () -> {
            System.out.println("Thread Name: " + getThreadName());
            sleepForInMillis(10000);
            System.out.println("Woke Up from Sleep: " + getThreadName());
            return getThreadName();
        };

        Callable<String> r2 = () -> {
            System.out.println("Thread Name: " + getThreadName());
            sleepForInMillis(5000);
            System.out.println("Woke Up from Sleep: " + getThreadName());
            return getThreadName();
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(r1);
        completionService.submit(r2);

        IntStream.range(0, 2).forEach(i -> {
            try {
                System.out.println("Result: " + completionService.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

    }
}
