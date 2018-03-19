package com.nagihome.codility.l5;

public class CountDiv {

    public static void main(String[] args) {
        System.out.println("solution: " + solution(6, 11, 2));

    }

    public static int solution(int A, int B, int K) {

        int b = B/K;
        int a = (A > 0)?(A -1) / K:0;
        if(A == 0)
            b++;

        return b - a;
    }

}
