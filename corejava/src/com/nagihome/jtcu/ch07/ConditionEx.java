package com.nagihome.jtcu.ch07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionEx {

    private static Lock lock = new ReentrantLock();
    private static Condition isFull = lock.newCondition();
    private static Condition isEmpty = lock.newCondition();
    private static volatile Message message = new Message();

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();

        Producer p = new Producer(message);
        Consumer c = new Consumer(message);

        es.submit(p);
        es.submit(c);

        es.shutdown();
    }

    static class Producer implements Runnable {

        private Message message;

        public Producer(Message message) {
            this.message = message;
        }

        @Override
        public void run() {

            AtomicInteger i = new AtomicInteger(0);

            while (i.getAndIncrement() < 2) {

                lock.lock();
                System.out.println("Got the Lock: Producer");


                if (message.getMessage() != null) {

                    try {
                        System.out.println("Going to wait: Producer");
                        isFull.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Setting the shared varible");
                message.setMessage("Message " + i.get());
                isEmpty.signal();
                System.out.println("Unlocking: Producer");

                lock.unlock();
            }
        }
    }

    static class Consumer implements Runnable {

        private Message message;

        public Consumer(Message message) {
            this.message = message;
        }

        @Override
        public void run() {

            while (true) {

                lock.lock();

                System.out.println("Got the lock: Consumer");


                if (message.getMessage() == null) {

                    try {

                        System.out.println("Going to wait: Consumer");
                        isEmpty.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("message: " + message.getMessage());
                message.setMessage(null);

                isFull.signal();
                System.out.println("Unlocking: Consumer");

                lock.unlock();
            }
        }
    }


    static class Message {
        private volatile String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
