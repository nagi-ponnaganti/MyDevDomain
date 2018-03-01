package com.nagihome.jtcu.ch01;

public class JoinedThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(r1);
        t1.start();

        System.out.println("Waiting to join");
        t1.interrupt();
        t1.join();
        System.out.println("Joined");

    }

    private static Runnable r1 = () -> {
        try {
            System.out.println("Going to sleep");
            Thread.sleep(5000);
            System.out.println("wokeUp from sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

}
