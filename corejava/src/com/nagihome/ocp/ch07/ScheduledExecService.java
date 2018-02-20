package com.nagihome.ocp.ch07;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecService {

    public static void main(String[] args) {

        ScheduledExecutorService ses = null;

        try {

            ses = Executors.newSingleThreadScheduledExecutor();

            System.out.println(LocalDateTime.now());
            System.out.println("Subimtting the callable with some timedelay");
            ses.schedule(() -> {
                System.out.println("callable running: " + LocalDateTime.now());
            }, 2, TimeUnit.SECONDS);
            System.out.println("CompletedSubimtting the callable with some timedelay");
            System.out.println(LocalDateTime.now());

            System.out.println(LocalDateTime.now());
            System.out.println("Subimtting the callable with fixedRate");
            ses.scheduleAtFixedRate(() -> {
                System.out.println("callable running: " + LocalDateTime.now());
            }, 2, 5, TimeUnit.SECONDS);
            System.out.println("Completed Subimtting the callable with fixedRate");
            System.out.println(LocalDateTime.now());


        } finally {
            if (ses != null)
                ses.shutdown();
        }

    }

}
