package com.nagihome.jtcu.ch06;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.nagihome.jtcu.util.ThreadUtil.*;

public class CyclicBarrierEx {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        MyRunnable r1 = new MyRunnable(cyclicBarrier);
        printBarrierInfo(cyclicBarrier);
        es.submit(r1);
        printBarrierInfo(cyclicBarrier);
        es.submit(r1);
        printBarrierInfo(cyclicBarrier);
        es.submit(r1);
        printBarrierInfo(cyclicBarrier);

        printBarrierInfo(cyclicBarrier);
        es.submit(r1);
        printBarrierInfo(cyclicBarrier);
        es.submit(r1);
        printBarrierInfo(cyclicBarrier);
        es.submit(r1);
        printBarrierInfo(cyclicBarrier);

        es.shutdown();

    }


    static class MyRunnable implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public MyRunnable(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            printThreadName();
            try {
                System.out.println("Going to Wait on Barrier" + getThreadName());
                cyclicBarrier.await();
                System.out.println("Barrier Released: " + getThreadName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printBarrierInfo(CyclicBarrier cyclicBarrier) {
        System.out.println(ToStringBuilder.reflectionToString(cyclicBarrier, ToStringStyle.MULTI_LINE_STYLE));
    }


}
