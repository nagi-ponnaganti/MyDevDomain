package com.nagihome.javathreads.ch01;

public class InterruptDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(r1);
        t1.start();

        while(true) {
            double random = Math.random();
            if(random > 0.499999 && random < 0.500001) {
                break;
            }
        }

        System.out.printf("Will Interrupt Thread Now \n");
        t1.interrupt();
    }


    private static Runnable r1 = () -> {
        System.out.printf("Inside Thread with Name: %s \n", Thread.currentThread().getName());
        int counter = 0;
        while (!Thread.interrupted()) {
            System.out.printf("Counter int the Thread: %s \n", counter++);
        }

        System.out.printf("interrupted: %s, isInterrupted: %s", Thread.interrupted(), Thread.currentThread().isInterrupted());
    };
}
