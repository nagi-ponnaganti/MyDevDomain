package com.nagihome.javathreads.ch01;

public class Chapter01Main {

    private final static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        System.out.println(String.format("Thread Name %s State %s ", t1.getName(), t1.getState()));
        t1.start();
        t2.start();
        System.out.println(String.format("Thread Name %s State %s ", t1.getName(), t1.getState()));
        System.out.println(String.format("Thread Name %s State %s ", t2.getName(), t2.getState()));
        Thread.sleep(3000);
        System.out.println(String.format("Thread Name %s State %s ", t1.getName(), t1.getState()));
        System.out.println(String.format("Thread Name %s State %s ", t2.getName(), t2.getState()));

    }

    private final static Runnable r1 = () -> {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " Thread got the Lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Thread released the Lock");
        }
    };
}
