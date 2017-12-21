package com.nagihome.javathreads.ch01;

public class IntSleep {

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(r1);

        System.out.println("Starting the Thread");

        t1.start();

        Thread.sleep(2000);

        System.out.println("Wake-Up From Sleep");

        t1.interrupt();

    }

    private static Runnable r1 = () -> {

        while(!Thread.interrupted()) {
            System.out.println("Hello");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    };

}
