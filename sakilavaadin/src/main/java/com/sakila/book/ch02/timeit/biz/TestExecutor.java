package com.sakila.book.ch02.timeit.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestExecutor {


    public static Collection<String> execute(TestSet testSet, long times) {

        List<String> results = new ArrayList<>();

        testSet.init();

        Stream.of(testSet.getTests()).forEach(t -> {
            long time = execute(t, times);
            results.add(String.format("Test: %s Time: %s", t.getName(), time));
        });

        return results;
    }


    public static long execute(Test test, long times) {

        long startTime = System.nanoTime();

        LongStream.range(0, times).forEach(i -> test.execute());

        long finishTime = System.nanoTime();

        return (finishTime - startTime) / 1000000;
    }

}
