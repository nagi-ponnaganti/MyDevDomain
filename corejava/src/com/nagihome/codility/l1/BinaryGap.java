package com.nagihome.codility.l1;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.printf("test1: %s %s \n", Integer.toBinaryString(9), solution1(9));
        System.out.printf("test2: %s %s \n", Integer.toBinaryString(51712), solution1(51712));
        System.out.printf("test1: %s %s \n", Integer.toBinaryString(9), solution2(9));
        System.out.printf("test2: %s %s \n", Integer.toBinaryString(51712), solution2(51712));
    }

    public static int solution1(int N) {

        int rightMostBit = 0;
        int binaryGap = 0;
        int counter = -1;

        while (N > 0) {

            rightMostBit = N & 1;
            N = N >> 1;

            if (rightMostBit == 0 && counter >= 0) {
                counter++;
            }

            if (rightMostBit == 1) {

                if (binaryGap < counter)
                    binaryGap = counter;

                counter = 0;
            }
        }

        return binaryGap;
    }

        public static int solution2(int N) {

        int binaryGap = 0;
        int count = 0;
        boolean processedOne = false;

        for (; N > 0; N = N / 2) {

            if (N % 2 == 0) {
                count++;
            } else {
                if (binaryGap < count && processedOne) {
                    binaryGap = count;
                }
                processedOne = true;
                count = 0;
            }
        }

        return binaryGap;
    }

}
