package com.nagihome.javathreads.ch07;

import com.nagihome.javathreads.ch06.CyclicBarrierExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteReentrantLockEx {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        System.out.println("Submitting Tasks");
        executorService.submit(new ReaderThread(readWriteLock));
        executorService.submit(new ReaderThread(readWriteLock));
        executorService.submit(new ReaderThread(readWriteLock));
        executorService.submit(new WriterThread(readWriteLock));
        executorService.submit(new WriterThread(readWriteLock));
        executorService.submit(new WriterThread(readWriteLock));


//        System.out.println("Shutting Down Initiated");
        executorService.shutdown();

//        System.out.println("Awaiting Termination");
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Terminating Now");
    }

    private static class ReaderThread implements Runnable {

        private ReentrantReadWriteLock readWriteLock;

        public ReaderThread(ReentrantReadWriteLock readWriteLock) {
            this.readWriteLock = readWriteLock;
        }

        @Override
        public void run() {
            System.out.printf("\n%s Getting the Read Lock", Thread.currentThread().getName());
            readWriteLock.readLock();
            System.out.printf("\n%s Got the Read Lock", Thread.currentThread().getName());
        }
    }

    private static class WriterThread implements Runnable {

        private ReentrantReadWriteLock readWriteLock;

        public WriterThread(ReentrantReadWriteLock readWriteLock) {
            this.readWriteLock = readWriteLock;
        }

        @Override
        public void run() {
            System.out.printf("\n%s Getting the Writer Lock", Thread.currentThread().getName());
            readWriteLock.writeLock();
            System.out.printf("\n%s Got the Write Lock", Thread.currentThread().getName());
        }
    }

}
