package com.nagihome.ocp.ch07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SheepManager {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        SheepManager sh = new SheepManager();
        IntStream.range(0, 100000).forEach(i ->
                es.submit(() -> sh.incrementAndReport()));

        es.shutdown();
    }

    private void incrementAndReport() {
        System.out.println("ThreadName: " + Thread.currentThread().getName() + " Updated Counter to: " + counter.incrementAndGet());
    }



}
