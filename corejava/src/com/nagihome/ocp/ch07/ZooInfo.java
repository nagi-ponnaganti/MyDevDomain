package com.nagihome.ocp.ch07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ZooInfo {

    public static void main(String[] args) {

        ExecutorService es = null;

        try {

            es = Executors.newSingleThreadExecutor();
            es.submit(() -> System.out.println("Printing Zoo Inventory"));
            es.submit(() -> IntStream.range(0, 10).forEach(i -> System.out.println("In Loop with num: " + i)));
            es.submit(() -> System.out.println("Printing Zoo Inventory"));

        } finally {
            if (es != null)
                es.shutdown();
        }
    }

}
