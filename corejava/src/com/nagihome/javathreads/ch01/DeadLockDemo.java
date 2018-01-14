package com.nagihome.javathreads.ch01;

public class DeadLockDemo {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void method1() throws InterruptedException {

        synchronized (lock1) {
            System.out.printf("In Method1 Thread %s got the lock1 \n", Thread.currentThread().getName());
            synchronized (lock2) {
                System.out.printf("In Method1 Thread %s got the lock2 \n", Thread.currentThread().getName());
            }
        }
    }

    private void method2() throws InterruptedException {
        synchronized (lock2) {
            System.out.printf("In Method2 Thread %s got the lock2 \n", Thread.currentThread().getName());
            synchronized (lock1) {
                System.out.printf("In Method2 Thread %s got the lock1 \n", Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {

        DeadLockDemo dld = new DeadLockDemo();

        Runnable r1 = () -> {
            try {
                dld.method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                dld.method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        System.out.printf("Thread States: %s %s \n", t1.getState(), t2.getState());
    }

}
