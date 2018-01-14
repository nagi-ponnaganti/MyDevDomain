package com.nagihome.pc;

import java.util.Arrays;

public class RotateArrayByItSelf {

    public static int[] rotate(int[] input, int rotateByNum) {

        for (int i = 0; i < rotateByNum; i++) {
            for (int j = input.length - 1; j > 0; j--) {
                int temp = input[j];
                input[j] = input[j - 1];
                input[j - 1] = temp;
                System.out.printf("Shifting the position from %s to %s\n", j, j - 1);
            }
        }

        System.out.printf("output: %s", Arrays.toString(input));

        return input;
    }

}
