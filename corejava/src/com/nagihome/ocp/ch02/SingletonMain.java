package com.nagihome.ocp.ch02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingletonMain {

    private SingletonMain() {

    }

    private static SingletonMain instance;

    public static synchronized SingletonMain getInstance() {

        if (instance == null) {
            synchronized (SingletonMain.class) {
                if (instance == null) {
                    instance = new SingletonMain();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach(i -> {
            es.submit(() -> {
                System.out.printf("Thread Name: %s With instance Hashcode: %s\n", Thread.currentThread().getName(), SingletonMain.getInstance());
            });
        });
    }

}
