package com.nagihome.jtcu.ch01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadsState {

    private static Runnable r1 = () -> System.out.println("Thread Name: " + Thread.currentThread().getName());

    private static Runnable r2 = () -> {

        synchronized (ThreadsState.class) {
            IntStream.range(0, 10000).forEach(i -> {
            });
        }
    };

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(r1);
        System.out.println("Thread State 01: " + t1.getState());
        t1.start();
        System.out.println("Thread Priority: " + t1.getPriority());
        System.out.println("Thread is Deamon: " + t1.isDaemon());
        System.out.println("Thread is alive: " + t1.isAlive());
        System.out.println("Thread State 02: " + t1.getState());

        Thread t2 = new Thread(r1, "thread t1");
        System.out.println("Thread Name: " + t2.getName());

/*        Thread t3 = new Thread(r2);
        Thread t4 = new Thread(r2);

        t3.start();
        t4.start();
        while (true) {
            String state = t4.getState().name();
            if (state.equals("BLOCKED")) {
                System.out.println("t4 state: " + state);
                break;
            }
        }

        Thread t5 = new Thread(r1);
        Thread t6 = new Thread(r1);

        */

        CountDownLatch c1 = new CountDownLatch(3);

        Thread t7 = new Thread(new Waiter(c1));
        Thread t8 = new Thread(new Decrementar(c1));
        t7.start();
        Thread.sleep(1000);
        System.out.println("t7 state: " + t7.getState());

        t8.start();
        System.out.println("t8 state: " + t8.getState());

        Thread t9 = new Thread(r1, "t9");
        Thread t10 = new Thread(r1, "t10");
        Thread t11 = new Thread(r1, "t11");
        Thread t12 = new Thread(r1, "t12");
        t10.setPriority(Thread.MIN_PRIORITY);
        t10.setDaemon(true);
        t12.setPriority(Thread.MIN_PRIORITY);
        t9.setPriority(Thread.MAX_PRIORITY);
        t11.setPriority(Thread.NORM_PRIORITY);

        t10.start();
        t12.start();
        t11.start();
        t9.start();

        System.out.println("t9 state: " + t9.getState());
        System.out.println("t10 state: " + t10.getState());
        System.out.println("t11 state: " + t11.getState());
        System.out.println("t12 state: " + t12.getState());
        Thread.sleep(200);
    }

    static class Waiter implements Runnable {

        private CountDownLatch c1;

        public Waiter(CountDownLatch c1) {
            this.c1 = c1;
        }

        @Override
        public void run() {
            try {
                System.out.println("In Waiter, awaiting now");
                c1.await(5, TimeUnit.SECONDS);
                System.out.println("In Waiter, got of from await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Decrementar implements Runnable {

        private CountDownLatch c1;

        public Decrementar(CountDownLatch c1) {
            this.c1 = c1;
        }

        @Override
        public void run() {

            c1.countDown();
            System.out.println("coutdown latch by 1");
            IntStream.range(0, 10000).forEach(i -> {
            });

            c1.countDown();
            System.out.println("coutdown latch by 2");
            IntStream.range(0, 10000).forEach(i -> {
            });

            c1.countDown();
            System.out.println("coutdown latch by 3");
            IntStream.range(0, 10000).forEach(i -> {
            });

        }
    }


}
