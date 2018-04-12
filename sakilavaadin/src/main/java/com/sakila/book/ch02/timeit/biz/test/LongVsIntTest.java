package com.sakila.book.ch02.timeit.biz.test;

import com.sakila.book.ch02.timeit.biz.Test;
import com.sakila.book.ch02.timeit.biz.TestSet;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LongVsIntTest implements TestSet {

    private int iterations;

    private class IntTest implements Test {

        @Override
        public void execute() {
            IntStream.range(0, iterations).forEach(i -> {
            });
        }

        @Override
        public String getName() {
            return "for(int i...)";
        }
    }

    private class LongTest implements Test {

        @Override
        public void execute() {
            LongStream.range(0, iterations).forEach(i -> {
            });
        }

        @Override
        public String getName() {
            return "for(long i...)";
        }
    }

    @Override
    public String getTitle() {
        return "long vs int loop";
    }

    @Override
    public String getDescription() {
        return "One could think a loop controlled by an int is faster than one controlled by a long. Let's check how much the difference is.";
    }

    @Override
    public void init() {
        iterations = 100000;
    }

    @Override
    public long getDefaultTimes() {
        return 10000;
    }

    @Override
    public Test[] getTests() {
        return new Test[]{new IntTest(), new LongTest()};
    }

}
