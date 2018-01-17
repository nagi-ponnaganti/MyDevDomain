package com.nagihome.ej.ch02;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Item07 {

    public static void main(String[] args) throws InterruptedException {

        Stack stack = new Stack();
        ExecutorService es = Executors.newFixedThreadPool(1);

        printStats();

//        System.out.println("Pushing all elements");
        IntStream.rangeClosed(0, 1000000).forEach(i -> es.submit(new Pusher(stack)));
//        System.out.println("Poping all elements");
        IntStream.rangeClosed(0, 1000000).forEach(i -> es.submit(new Poper(stack)));

        Thread.sleep(10000);
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);

        printStats();

    }

    private static void printStats() {
        int mb = 1024*1024;

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        //Print used memory
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        //Print free memory
        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);

        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);

        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
    }

    static class Pusher implements Runnable {

        private Stack stack;

        public Pusher(Stack stack) {
            this.stack = stack;
        }

        @Override
        public void run() {
            double value = Math.random();
//            System.out.printf("Pushing Element: %s \n", value);
            stack.push(value);
        }
    }

    static class Poper implements Runnable {

        private Stack stack;

        public Poper(Stack stack) {
            this.stack = stack;
        }

        @Override
        public void run() {
            Object value = stack.pop();
//            System.out.printf("Poping Element: %s \n", value);
        }
    }


    static class Stack {

        private Object[] elements;
        private int size = 0;
        private final int DEFAULT_CAPACITY = 16;

        public Stack() {
            this.elements = new Object[DEFAULT_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (elements.length == 0)
                throw new AssertionError();
            Object result = elements[--size];
            elements[size] = null;
            return result;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
//                System.out.println("After Doubling the size: " + elements.length);
            }
        }

    }

}
