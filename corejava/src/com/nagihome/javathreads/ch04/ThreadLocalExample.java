package com.nagihome.javathreads.ch04;

public class ThreadLocalExample {

    public static void main(String[] args) throws InterruptedException {

        Runnable01 r1 = new Runnable01();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    static class Runnable01 implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {

            if(threadLocal.get() == null)
                threadLocal.set(0);

            System.out.println("Current Thread Value: " + threadLocal.get());
            threadLocal.set(threadLocal.get() + 1);
            System.out.println("Chnaged Thread Value: " + threadLocal.get());

        }
    }
}
