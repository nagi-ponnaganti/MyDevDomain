package com.nagihome.ocp.ch01;

import java.util.stream.IntStream;

public class Outer {

    private String greeting = "Hi";
    private int length = 5;

    protected class Inner {
        private int times = 3;

        private void go() {
            IntStream.range(0, 3).forEach(i -> System.out.println(greeting + " number " + i));
        }
    }

    public void calculate() {
        int width = 4;
        class Inner {
            protected void multiply() {
                System.out.println("Multiply: " + (width * length));
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.go();
        outer.calculate();

        Integer i = 2;
        System.out.println(++i);
        System.out.println(i);

    }

}
