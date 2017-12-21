package com.nagihome.javathreads.ch01;

public class JoiningDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(r1);
        t1.start();

        System.out.println("Calling Join Method");
        t1.join(2000);
        System.out.println("Join Method Completed");
    }


    private static Runnable r1 = () -> {

        System.out.printf("Thread Name: %s \n", Thread.currentThread().getName());
        System.out.printf("Going Sleep \n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.print(e);
        }
        System.out.printf("Woke-Up From Sleep \n");

    };

}
