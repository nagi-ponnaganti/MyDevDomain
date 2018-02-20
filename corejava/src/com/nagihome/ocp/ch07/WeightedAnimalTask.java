package com.nagihome.ocp.ch07;

import java.util.Random;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeightedAnimalTask extends RecursiveTask<Double> {

    private Double[] weights;
    private int start;
    private int end;

    public WeightedAnimalTask(Double[] weights, int start, int end) {
        this.weights = weights;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {

        if (end - start <= 3) {
            double sum = 0;
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: "+i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start + ((end - start) / 2);
            RecursiveTask<Double> otherTask = new WeightedAnimalTask(weights, start, middle);
            otherTask.fork();
            return new WeightedAnimalTask(weights,middle,end).compute() + otherTask.join();
        }

    }
}
