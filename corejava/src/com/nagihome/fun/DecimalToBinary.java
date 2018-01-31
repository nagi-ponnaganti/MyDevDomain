package com.nagihome.fun;

import java.util.Arrays;
import java.util.stream.Stream;

public class DecimalToBinary {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(convertToBinaryFromBase10(25)));
    }


    private static int[] convertToBinaryFromBase10(int number) {

        int[] output = new int[32];

        int i = 31;
        while (number > 0) {
            output[i--] = number % 2;
            number = number / 2;
        }

        return output;
    }

}
