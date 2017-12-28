package com.nagihome.javathreads.ch06;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    private static CyclicBarrier barrier = new CyclicBarrier(3, () -> {System.out.println("Barrier Action");});

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(6);
        System.out.println("Submitting Tasks");
        executorService.submit(new RunnableThread(barrier));
        executorService.submit(new RunnableThread(barrier));
        executorService.submit(new RunnableThread(barrier));
        executorService.submit(new RunnableThread(barrier));
        executorService.submit(new RunnableThread(barrier));
        executorService.submit(new RunnableThread(barrier));


//        System.out.println("Shutting Down Initiated");
        executorService.shutdown();

//        System.out.println("Awaiting Termination");
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Terminating Now");

    }

    private static class RunnableThread implements Runnable {
        private CyclicBarrier barrier;

        public RunnableThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {

            System.out.printf("Thread Name: %s\n", Thread.currentThread().getName());

            try {
                synchronized (barrier) {
                    System.out.printf("Number Waiting: %s\n", barrier.getNumberWaiting());
                }

                barrier.await();

                System.out.printf("Thread Released: %s\n", Thread.currentThread().getName());

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
