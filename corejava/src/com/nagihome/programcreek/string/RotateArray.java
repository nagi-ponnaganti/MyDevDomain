package com.nagihome.programcreek.string;

import java.util.Arrays;

public class RotateArray {

    /*Rotate an array of n elements to the right by k steps.
    For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
    How many different ways do you know to solve this problem?
    */
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray01(input, 3);
        input = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray02(input, 3);
    }


    private static int[] rotateArray01(int[] input, int rotateBy) {

        int[] output = new int[input.length];
        int j = 0;

        for (int i = input.length - rotateBy; i < input.length; i++) {
            output[j++] = input[i];
        }

        for (int i = 0; i < input.length - rotateBy; i++) {
            output[j++] = input[i];
        }

        System.out.printf("rotateArray01 Output Array: %s\n", Arrays.toString(output));

        return output;
    }

    private static int[] rotateArray02(int[] input, int rotateBy) {

        int temp;
        int j = 0;
        for (int i = input.length - rotateBy; i < input.length; i++) {
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            j++;
        }

        System.out.printf("rotateArray02 Output Array: %s\n", Arrays.toString(input));

        return input;
    }

}
