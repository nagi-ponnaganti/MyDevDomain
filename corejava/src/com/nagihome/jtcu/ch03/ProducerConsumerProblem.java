package com.nagihome.jtcu.ch03;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerProblem {

    public static void main(String[] args) {

        Producer p = new Producer();
        Consumer c = new Consumer(p);

        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(p);
        es.submit(c);


    }


    static class Producer implements Runnable {

        private int MAX_QUEUE_ITEMS = 5;
        private Vector<String> queue = new Vector<>();
        private AtomicInteger counter = new AtomicInteger(0);

        @Override
        public void run() {

            while (true) {
                putMessage();
            }

        }

        private synchronized void putMessage() {
            try {
                if (queue.size() == MAX_QUEUE_ITEMS) {

                    System.out.println("Queue Maxed Out");
                    wait();
                    System.out.println("producer Woke-up From wait");
                }

                System.out.println("Adding Message To Queue");
                queue.add("Message: " + counter.incrementAndGet());
                TimeUnit.MILLISECONDS.sleep(1000);

                if (queue.size() == MAX_QUEUE_ITEMS)
                    notify();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public synchronized String getMessage() {

            String value = null;

            try {
                if (queue.size() == 0) {

                    System.out.println("No Messages in the queue");
                    wait();
                    System.out.println("consumer Woke-up From wait");

                }

                System.out.println("Taking Message From Queue");
                value = queue.firstElement();
                queue.removeElementAt(0);
                if (queue.size() == 0)
                    notify();
                TimeUnit.MILLISECONDS.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return value;

        }

    }

    static class Consumer implements Runnable {

        private Producer producer;

        public Consumer(Producer producer) {
            this.producer = producer;
        }

        @Override
        public void run() {

            while (true) {
                System.out.println(producer.getMessage());
            }

        }
    }

}
