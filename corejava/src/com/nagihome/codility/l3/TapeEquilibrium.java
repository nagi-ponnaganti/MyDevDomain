package com.nagihome.codility.l3;

public class TapeEquilibrium {

    public static void main(String[] args) {

        System.out.println("solution1: " + solution(new int[]{1, 2, 3, 4, 0}));

    }

    private static int solution(int[] N) {
        int minDiff = Integer.MAX_VALUE;
        int rhs = 0;
        int lhs = 0;
        int currDiff = 0;

        // IntStream.of(N).sum(); Performance issue while using Intstream
        for(int i : N) {
            lhs += i;
        }

        for (int i = N.length - 1; i > 0; i--) {
            lhs -= N[i];
            rhs += N[i];

            currDiff = Math.abs(lhs - rhs);

            if (currDiff < minDiff) {
                minDiff = currDiff;
            }
        }

        return minDiff;
    }

}
