package com.nagihome.concurrent.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static com.nagihome.concurrent.api.ThreadUtil.*;

public class ExecutorServiceMain {

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
        List<Future<String>> results = new ArrayList<>();
        results.add(executorService.submit(r1));
        results.add(executorService.submit(r2));

        while (results.size() > 0) {
            List<Future<String>> doneResults = new ArrayList<>();
            results.stream().filter(f -> f.isDone()).forEach(f -> {
                try {
                    System.out.println("This task is done: " + f.get());
                    doneResults.add(f);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
            results.removeAll(doneResults);
            sleepForInMillis(1000);
        }

        System.out.println("All Tasks Are Done");

        executorService.shutdown();

    }

}
