package com.sakila.book.ch02.timeit.biz;

public interface TestSet {

    String getTitle();

    String getDescription();

    void init();

    long getDefaultTimes();

    Test[] getTests();
}
