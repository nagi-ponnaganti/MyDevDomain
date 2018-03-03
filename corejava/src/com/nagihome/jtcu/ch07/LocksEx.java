package com.nagihome.jtcu.ch07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.nagihome.jtcu.util.ThreadUtil.*;

public class LocksEx {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        ReadWriteLock rwLock = new ReentrantReadWriteLock();

        Runnable r1 = () -> {

            lock.lock();
            System.out.println("Got the Lock: " + getThreadName());

            sleepForInMillis(2000);

            lock.unlock();
            System.out.println("Unlocked: " + getThreadName());

        };


        Runnable r2 = () -> {

            try {
                AtomicBoolean flag = new AtomicBoolean(lock.tryLock(5, TimeUnit.SECONDS));

                if (flag.get()) {
                    System.out.println("Got the Lock: " + getThreadName());
                    sleepForInMillis(1000);
                } else {
                    System.out.println("Didn't get the lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Unlocked: " + getThreadName());
            }
        };

        Runnable r3 = () -> {

            try {
                rwLock.readLock().lock();
                System.out.println("Got the read lock: " + getThreadName());
                sleepForInMillis(2000);
                System.out.println("Read some Work");
                System.out.println("Relasing the lock: " + getThreadName());
                rwLock.readLock().unlock();

                rwLock.writeLock().lock();
                System.out.println("Got the write lock: " + getThreadName());
                sleepForInMillis(2000);
                System.out.println("write Some Work");
                System.out.println("Relasing the lock: " + getThreadName());
                rwLock.writeLock().unlock();

            } finally {
            }


        };

        ExecutorService es = Executors.newCachedThreadPool();

//        es.submit(r1);
//        es.submit(r1);
//        es.submit(r2);
//        es.submit(r2);

        es.submit(r3);
        es.submit(r3);

        es.shutdown();
    }


}
