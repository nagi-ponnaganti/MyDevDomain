package com.nagihome.fun;

public class StringReverse {

    public static void main(String[] args) {
        System.out.println("String reverse: " + reverse("Hello World, This is Nagi"));
    }


    private static String reverse(String input) {

        char[] inputArray = input.toCharArray();
        int arrLength = input.length();
        for (int i = 0; i < arrLength / 2; i++) {
            char temp = inputArray[i];
            inputArray[i] = inputArray[arrLength - 1 - i ];
            inputArray[arrLength - 1 - i ] = temp;
        }

        return String.valueOf(inputArray);
    }


}
