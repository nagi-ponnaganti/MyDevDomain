package com.nagihome.pc;

import java.util.Arrays;

public class RotateByIntermediateArray {


    public static int[] rotate(int[] input, int rotateByRight) {
        if (rotateByRight > input.length)
            rotateByRight = rotateByRight / input.length;

        int[] output = new int[input.length];

        for (int i = 0; i < rotateByRight; i++) {
            output[i] = input[input.length - rotateByRight + i];
        }

        int j= 0;
        for(int i = rotateByRight; i < input.length; i++) {
            output[i] = input[j];
            j++;
        }

        System.out.printf("output: %s", Arrays.toString(output));

        return output;
    }

}
