package com.nagihome.jtcu.ch06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static com.nagihome.jtcu.util.ThreadUtil.*;


public class CountingSemaphoreEx {


    public static void main(String[] args) {

        Semaphore s = new Semaphore(1);
        SharedResource sr = new SharedResource(s);

        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(sr);
        es.submit(sr);
        es.submit(sr);

        es.shutdown();

    }

    static class SharedResource implements Runnable {

        private Semaphore semophore;

        public SharedResource(Semaphore semophore) {
            this.semophore = semophore;
        }

        @Override
        public void run() {

            try {

                semophore.acquire();
                System.out.printf("Semaphore Details: %s, %s, %s\n ",
                                semophore.availablePermits(),
                                semophore.hasQueuedThreads(),
                                semophore.getQueueLength());
                sleepForInMillis(2000);
                semophore.release();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
