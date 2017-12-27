package com.nagihome.javathreads.ch05;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

@RunWith(JUnit4.class)
public class ExploringExecutorsTest {

    private ExecutorService executorService = null;

    @Test(expected = NullPointerException.class)
    public void testNPEForNullTaskSubmission() {
        Runnable runnable = null;
        executorService.submit(runnable);
    }

    @Test(expected = RejectedExecutionException.class)
    public void testRejectionExecutionException() throws InterruptedException {
        Thread t1 = new Thread(r1);
        t1.start();
        t1.join();
        executorService.shutdownNow();
        executorService.submit(t1);
    }

    @Test
    public void testAwaitTerminationAfterShutdown() throws InterruptedException {
        executorService.submit(r1);
        long startTime = System.nanoTime();
        executorService.shutdown();
        long endTime = System.nanoTime();
        long diff = endTime - startTime;
        System.out.printf("startTime: %s endTime: %s diff: %ss\n", startTime, endTime, diff / 1e6);
        System.out.println("Wait Termination Started");
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Wait Termination Completed");
        Assert.assertTrue("Shutdown has to be true", executorService.isShutdown());
        Assert.assertTrue("Shutdown has to be true", executorService.isTerminated());
    }


    @Test
    public void testInvokeAll() throws InterruptedException {
        List<Future<String>> futures = executorService.invokeAll(callables);
        futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        Assert.assertEquals("Size have to be five", 5, futures.size());
    }

    @Test(expected = CancellationException.class)
    public void testInvokeAllWithTimeOut() throws InterruptedException {
        List<Future<String>> futures = executorService.invokeAll(callables, 1, TimeUnit.SECONDS);
        futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testInvokeAny() throws ExecutionException, InterruptedException {

        String stringFuture = executorService.invokeAny(callables);
        System.out.printf("stringFuture: %s ", stringFuture);

        Thread.sleep(5000);
    }

    private Runnable r1 = () -> {
        try {
            Thread.sleep(1000);
            System.out.printf("This Task Is Complete Now: %s\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    private Callable<String> c1 = () -> {
        try {
            Thread.sleep(1000);
            System.out.printf("This Task Is Complete Now: %s\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Thread.currentThread().getName();
    };

    private Collection<Callable<String>> callables = new ArrayList<>();

    @Before
    public void init() {

        callables.add(c1);
        callables.add(c1);
        callables.add(c1);
        callables.add(c1);
        callables.add(c1);
        executorService = Executors.newFixedThreadPool(5);

    }
}