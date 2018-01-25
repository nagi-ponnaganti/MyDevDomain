package com.nagihome.fun;

public class NumberReverse {

    public static void main(String[] args) {
        System.out.printf("Reverse a Number: %d", reverse(123456));
    }


    private static int reverse(int number) {

        int reverse = 0;

        while(number != 0) {
            reverse = (reverse * 10) + (number % 10);
            number = number / 10;
        }

        return reverse;
    }

}
