package com.nagihome.codility.l4;

public class FrogRiverOne {

    public static void main(String[] args) {
        System.out.println("Solution: " + solution(new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 5));
    }

    private static int solution(int[] A, int steps) {
        boolean[] stepsMap = new boolean[steps + 1];

        for (int i = 0; i < A.length; i++) {

            if (!stepsMap[A[i]]) {
                stepsMap[A[i]] = true;
                steps--;
            }

            if (steps == 0)
                return i;

        }


        return -1;
    }

}
