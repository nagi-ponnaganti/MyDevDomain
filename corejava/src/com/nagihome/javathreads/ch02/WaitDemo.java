package com.nagihome.javathreads.ch02;

public class WaitDemo {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Waiter(lock));

        t1.start();

        Thread.sleep(2000);

        System.out.println("Going to Trigger Notify");

        Thread t2 = new Thread(new Notifier(lock));
        t2.start();
    }

    static class Waiter implements Runnable {

        private Object lock;

        public Waiter(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock) {

                try {
                    System.out.println("Thread is going to Wait");
                    lock.wait(5000);
                    System.out.println("Thread is come out of Wait");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    static class Notifier implements Runnable {

        private Object lock;

        public Notifier(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {

            synchronized (lock) {

                System.out.println("Thread is going Notify");
                lock.notify();
                System.out.println("Thread is come out of Notify");

            }

        }
    }

}
