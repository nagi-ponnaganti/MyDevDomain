package com.nagihome.javathreads.ch06;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountdownlatchDemo {

    private static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Submitting Tasks");
        executorService.submit(new Waiter(latch));
        executorService.submit(new Waiter(latch));
        executorService.submit(new Waiter(latch));
        executorService.submit(new Waiter(latch));

//        System.out.println("Shutting Down Initiated");
        executorService.shutdown();

//        System.out.println("Awaiting Termination");
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Terminating Now");
    }

    /*
    class Decrementer implements Runnable {

        private CountDownLatch latch;

        public Decrementer(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

        }
    }*/

    static class Waiter implements Runnable {

        private CountDownLatch latch;

        Waiter(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            try {

                synchronized (latch) {
                    System.out.printf("Thread Got the Lock: %s\n", Thread.currentThread().getName());
                    latch.countDown();
                    System.out.printf("Latch Count: %s\n", latch.getCount());
                }

                latch.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Thread Released: %s\n", Thread.currentThread().getName());
        }
    }


}
