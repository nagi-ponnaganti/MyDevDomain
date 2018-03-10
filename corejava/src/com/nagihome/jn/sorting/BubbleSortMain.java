package com.nagihome.jn.sorting;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSortMain {

    public static void main(String[] args) {

        int[] input = new int[]{7, 6, 10, 2, 1, 3, 0};
        sort(input);
        System.out.println(IntStream.of(input).boxed().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

    }


    public static void sort(int[] input) {

        IntStream.range(0, input.length).forEach(times -> {
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    swap(input, i, i + 1);
                }
            }
        });
    }

    private static void swap(int[] input, int swapIndex1, int swapIndex2) {
        int temp = input[swapIndex1];
        input[swapIndex1] = input[swapIndex2];
        input[swapIndex2] = temp;
    }

}
