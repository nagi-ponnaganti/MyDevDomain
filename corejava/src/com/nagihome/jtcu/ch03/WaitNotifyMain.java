package com.nagihome.jtcu.ch03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyMain {

    public static void main(String[] args) {

        AtomicInteger counter = new AtomicInteger(0);
        Waiter w1 = new Waiter(counter);
        Notifier n1 = new Notifier(counter);

        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(w1);
        es.submit(w1);
        es.submit(n1);
    }

    static class Waiter implements Runnable {

        private AtomicInteger counter;

        public Waiter(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {

            synchronized (counter) {
                try {
                    System.out.println("In Critical Section: " + Thread.currentThread().getName());
                    System.out.println("Going to Wait: " + Thread.currentThread().getName());
                    counter.wait();
                    System.out.println("WokeUp From Wait: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Notifier implements Runnable {

        private AtomicInteger counter;

        public Notifier(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {

            synchronized (counter) {
                System.out.println("Going to Notify: " + Thread.currentThread().getName());
                counter.notifyAll();
                System.out.println("Notified: " + Thread.currentThread().getName());
                counter.decrementAndGet();
            }
        }
    }

}
