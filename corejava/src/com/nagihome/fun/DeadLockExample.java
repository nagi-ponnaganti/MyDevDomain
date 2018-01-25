package com.nagihome.fun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockExample {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(new DeadLockExample().r1);
        es.submit(new DeadLockExample().r2);
    }


    Runnable r1 = () -> {

        System.out.printf("This is Thread: %s and trying to get lock1\n", Thread.currentThread().getName());
        synchronized (lock1) {
            System.out.printf("%s Got the lock1\n", Thread.currentThread().getName());
            System.out.printf("%s trying to get lock2\n", Thread.currentThread().getName());
            synchronized (lock2) {
                System.out.printf("%s Got the lock2\n", Thread.currentThread().getName());
            }
        }

    };

    Runnable r2 = () -> {

        System.out.printf("This is Thread: %s and trying to get lock2\n", Thread.currentThread().getName());
        synchronized (lock2) {
            System.out.printf("%s Got the lock2\n", Thread.currentThread().getName());
            System.out.printf("%s trying to get lock1\n", Thread.currentThread().getName());
            synchronized (lock1) {
                System.out.printf("%s Got the lock1\n", Thread.currentThread().getName());
            }
        }

    };

}
