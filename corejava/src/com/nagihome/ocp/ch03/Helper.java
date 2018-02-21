package com.nagihome.ocp.ch03;

public class Helper {

    public static <U extends Exception> void printException(U e) {
        System.out.println(e.getMessage());
    }

    public static void main(String[] args) {
        Helper.printException(new NullPointerException("Null"));
        Helper.printException(new IllegalArgumentException("Illegal"));
    }
}
