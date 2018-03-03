package com.nagihome.jtcu.util;

import java.util.concurrent.TimeUnit;

public class ThreadUtil {

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }


    public static void printThreadName() {
        System.out.println("Current Thread Name: " + getThreadName());
    }

    public static void sleepForInMillis(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
