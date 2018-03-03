package com.nagihome.jtcu.ch03;

import java.util.concurrent.TimeUnit;

public class ThreadLocalExample {


    public static void main(String[] args) throws InterruptedException {

        MyRunnable sharedRunnable = new MyRunnable();

        Thread t1 = new Thread(sharedRunnable);
        Thread t2 = new Thread(sharedRunnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }


    static class MyRunnable implements Runnable {

        private ThreadLocal<String> name = new ThreadLocal<>();

        {
            name.set("DummyValue");
        }

        @Override
        public void run() {

            System.out.println("current value: " + name.get());

            name.set(String.valueOf(Math.random() * 1000D));

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Thread Name: %s and value: %s \n", Thread.currentThread().getName(), name.get());
        }
    }

}
