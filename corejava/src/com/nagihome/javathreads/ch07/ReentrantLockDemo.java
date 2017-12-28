package com.nagihome.javathreads.ch07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new RunnableThread(lock));
        executorService.submit(new RunnableThread(lock));
//        executorService.submit(new RunnableThread(lock));
//        executorService.submit(new RunnableThread(lock));

        //        System.out.println("Shutting Down Initiated");
        executorService.shutdown();

//        System.out.println("Awaiting Termination");
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Terminating Now");

    }


    private static class RunnableThread implements Runnable {

        private ReentrantLock lock;

        public RunnableThread(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            System.out.printf("%s trying to get the lock\n", Thread.currentThread().getName());
            lock.lock();
            System.out.printf("%s got the lock\n", Thread.currentThread().getName());
            System.out.printf("Sleeping for sometime\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            System.out.printf("Lock Details: %s\n", lock.toString());

            System.out.printf("%s releaseing the lock\n", Thread.currentThread().getName());
            lock.unlock();
            lock.unlock();

        }
    }

}
