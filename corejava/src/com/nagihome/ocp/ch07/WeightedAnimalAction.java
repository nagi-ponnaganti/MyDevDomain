package com.nagihome.ocp.ch07;

import java.util.Random;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

public class WeightedAnimalAction extends RecursiveAction {

    private Double[] weights;
    private int start;
    private int end;

    public WeightedAnimalAction(Double[] weights, int start, int end) {
        this.weights = weights;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        System.out.printf("In Compute Method: start: %s end: %s \n", start, end);
        if ((end - start) <= 3) {
            IntStream.range(start, end).forEach(i -> weights[i] = Double.valueOf(new Random().nextInt(100)));
        } else {
            int middle = start + ((end - start) / 2);
            invokeAll(new WeightedAnimalAction(weights, start, middle), new WeightedAnimalAction(weights, middle, end));
        }
    }
}
