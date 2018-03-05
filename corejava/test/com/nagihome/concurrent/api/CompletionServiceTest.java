package com.nagihome.concurrent.api;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

import static com.nagihome.concurrent.api.ThreadUtil.*;
import static org.junit.Assert.*;


public class CompletionServiceTest {

    @Test
    public void testPoll() throws ExecutionException, InterruptedException {

        completionService.submit(c1);
        completionService.submit(c1);

        assertTrue(completionService.poll(3, TimeUnit.SECONDS).get().startsWith("pool-1-thread"));

    }


    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
    private Callable<String> c1 = () -> {
        System.out.println("Work Started: " + getThreadName());
        sleepForInMillis(1000);
        System.out.println("Work Completed: " + getThreadName());
        return getThreadName();
    };


}
