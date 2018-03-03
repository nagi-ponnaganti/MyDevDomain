package com.nagihome.jtcu.ch06;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static com.nagihome.jtcu.util.ThreadUtil.printThreadName;
import static com.nagihome.jtcu.util.ThreadUtil.sleepForInMillis;


public class CountDownLatchEx {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);
        Waiter w1 = new Waiter(latch);
        OperationPerformer p1 = new OperationPerformer(latch);

        ExecutorService es = Executors.newCachedThreadPool();
        IntStream.rangeClosed(0, 90).forEach(i -> es.submit(w1));

        es.submit(p1);

        es.shutdown();

        while(!es.isTerminated()) {
            System.out.println("Submitted tasks are not yet completed, sleep for 3 seconds");
            sleepForInMillis(3000);
        }

    }


    static class Waiter implements Runnable {

        private CountDownLatch latch;

        public Waiter(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Latch waiting");
            printThreadName();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Out of latch");
        }
    }

    static class OperationPerformer implements Runnable {

        private CountDownLatch latch;

        public OperationPerformer(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            sleepForInMillis(2000);
            System.out.println("First Step Completed");
            latch.countDown();

            sleepForInMillis(1000);
            System.out.println("Second Step Completed");
            latch.countDown();

            sleepForInMillis(3000);
            System.out.println("Thread Step Completed");
            latch.countDown();

            printThreadName();
            System.out.println("All Tasks Completed");

        }
    }

}
