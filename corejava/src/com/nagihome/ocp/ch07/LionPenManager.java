package com.nagihome.ocp.ch07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class LionPenManager {

    public static void main(String[] args) throws InterruptedException {


        CyclicBarrier c1 = new CyclicBarrier(4);
        CyclicBarrier c2 = new CyclicBarrier(4);

        LionPenManager manager = new LionPenManager();
        final ExecutorService es = Executors.newCachedThreadPool();
        final List<Future<Object>> tasks = new ArrayList<>();

        try {
            IntStream.range(0, 4).forEach(i -> tasks.add((Future<Object>) es.submit(() -> {
                try {
                    manager.performTasks(c1, c2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            })));

            System.out.println("Submittion Complete");

            tasks.stream().forEach(i -> {
                try {
                    i.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            System.out.println("Get on tasks Complete");


        } finally {
            es.shutdown();
            es.awaitTermination(10, TimeUnit.SECONDS);
        }

    }

    private void performTasks(CyclicBarrier c1, CyclicBarrier c2) throws BrokenBarrierException, InterruptedException {

        removeAnimals();
        c1.await();
        cleanPlace();
        c2.await();
        bringBackAnimals();

    }

    private void bringBackAnimals() {
        System.out.println("Bring Back Animals: " + Thread.currentThread().getName());
    }

    private void cleanPlace() {
        System.out.println("Clean Place: " + Thread.currentThread().getName());
    }

    private void removeAnimals() {
        System.out.println("Removing Animals: " + Thread.currentThread().getName());
    }

}
