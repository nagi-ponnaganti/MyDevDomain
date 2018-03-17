package com.nagihome.codility.l3;

public class PermMissingElem {

    public static void main(String[] args) {
        System.out.println("solution: " + solution(new int[]{2, 3, 1, 5}));
    }

    public static int solution(int[] data) {

        long N = data.length + 1;
        long total = (N * (N + 1)) / 2;

        long sum = 0L;

        for (int i : data) {

            sum += i;
        }

        return (int)(total - sum);
    }

}
