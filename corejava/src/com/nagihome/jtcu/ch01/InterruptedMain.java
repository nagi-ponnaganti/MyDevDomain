package com.nagihome.jtcu.ch01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class InterruptedMain {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger(0);

        Thread t1 = new Thread(new Counter(counter));
        Thread t2 = new Thread(new Counter(counter));

        t1.start();
        t2.start();

        System.out.println("debug1");

        while (true) {
            double n = Math.random();
            if (n >= 0.49999999 && n <= 0.50000001)
                break;
        }

        System.out.println("debug2");

        t1.interrupt();
        t2.interrupt();


    }

    static class Counter implements Runnable {

        AtomicInteger counter;

        public Counter(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            try {
                Thread t = Thread.currentThread();
                while (!t.interrupted()) {
                    Thread.sleep(1000);
                    System.out.printf("Thread Name: %s Counter Value: %s\n", t.getName(), counter.incrementAndGet());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
