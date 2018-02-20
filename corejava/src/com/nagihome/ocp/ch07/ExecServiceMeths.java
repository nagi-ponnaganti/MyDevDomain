package com.nagihome.ocp.ch07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecServiceMeths {

    private static Runnable r = () -> {

        System.out.println("Going to sleep : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WakeUp from sleep : " + Thread.currentThread().getName());

    };


    private static Callable<String> c = () -> {

        System.out.println("Going to sleep : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WakeUp from sleep : " + Thread.currentThread().getName());

        return Thread.currentThread().getName();
    };

    public static void main(String[] args) {

        ExecutorService es = null;

        try {

            es = Executors.newFixedThreadPool(3);
            Future<?> f1 = es.submit(r);
            System.out.println("Submit Of Task Done: ");
            System.out.println("Get Object: " + f1.get());

            es.invokeAll(Stream.of(c, c, c, c).collect(Collectors.toList())).stream().forEach(f -> {
                try {
                    System.out.println("Future Value: " + f.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("invokeAny: " + es.invokeAny(Stream.of(c, c, c, c).collect(Collectors.toList())));

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

}
