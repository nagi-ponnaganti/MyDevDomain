package com.nagihome.codility.l2;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        System.out.println("Solution1: " + solution1(new int[] {1,1,2,2,1,3,3}));
    }

    public static int solution1(int[] N) {

        int oddNumber = 0;

        for (int i = 0; i < N.length; i++) {
            oddNumber ^= N[i];
        }

        return oddNumber;

    }

}
