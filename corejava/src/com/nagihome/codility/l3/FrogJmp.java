package com.nagihome.codility.l3;

public class FrogJmp {

    public static void main(String[] args) {
        System.out.println("solution1: " + solution(10, 85, 30));
    }

    public static int solution(int X, int Y, int D) {
        return (int) Math.ceil((Y - X) / (double)D);

    }

}
