package com.nagihome.codility.l4;

import java.util.Arrays;

public class PermCheck {

    public static void main(String[] args) {
        System.out.println("Solution: " + solution(new int[]{1,2,4,5}));
    }

    public static int solution(int[] A) {


        Arrays.sort(A);

        if (A[0] != 1) {
            return 0;
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i + 1]) {
                return 0;
            }
        }
        return 1;
    }

}
