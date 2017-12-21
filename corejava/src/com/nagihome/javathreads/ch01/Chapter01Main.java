package com.nagihome.javathreads.ch01;

public class Chapter01Main {

    private final static Object lock = new Object();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        System.out.printf("Thread Name %s State %s \n", t1.getName(), t1.getState());
        t1.start();
        t2.start();
        System.out.printf("Thread Name %s State %s \n", t1.getName(), t1.getState());
        System.out.printf("Thread Name %s State %s \n", t2.getName(), t2.getState());
        Thread.sleep(3000);
        System.out.printf("Thread Name %s State %s \n", t1.getName(), t1.getState());
        System.out.printf("Thread Name %s State %s \n", t2.getName(), t2.getState());

        System.out.printf("No Of Processors: %s \n", Runtime.getRuntime().availableProcessors());

        Thread t3 = new Thread(r1);
        System.out.printf("Check if Thread Is Daemon: %s and state: %s \n", t3.isDaemon(), t3.getState());
        t3.setDaemon(true);
        System.out.printf("Check if Thread Is Daemon: %s and state: %s \n", t3.isDaemon(), t3.getState());
        t3.start();
        System.out.printf("Check if Thread Is Daemon: %s and state: %s \n", t3.isDaemon(), t3.getState());

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
