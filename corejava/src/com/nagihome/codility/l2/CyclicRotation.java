package com.nagihome.codility.l2;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        System.out.println("solution1: " + Arrays.toString(solution1(new int[]{1, 2, 3, 4, 5, 6}, 4)));
    }

    public static int[] solution1(int[] N, int k) {

        for (int i = 0; i < k; i++) {
            for (int j = N.length - 1; j > 0; j--) {
                int temp = N[j];
                N[j] = N[j - 1];
                N[j - 1] = temp;
            }
        }

        return N;
    }

}
