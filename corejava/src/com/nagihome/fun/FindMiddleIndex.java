package com.nagihome.fun;

public class FindMiddleIndex {


    public static void main(String[] args) {

        System.out.println("program started");

        int[] input = {1, 2, 3, 4, 10};
        int middleIndex = input.length / 2;

        System.out.printf("middle index: %s\n", middleIndex);

        int lhsIndex = middleIndex;
        int rhsIndex = middleIndex + 1;

        int lhsSum = lhsSum(input, lhsIndex);
        int rhsSum = rhsSum(input, rhsIndex);

        String direction = findDirection(lhsSum, rhsSum);


        while (true) {

            System.out.printf("lhsSum: %s rhsSum: %s\n", lhsSum, rhsSum);

            if (lhsSum == rhsSum) {
                System.out.println("Sum is good");
                System.out.printf("The Middle Index where the lhs sum == rhs sum is: %s %s\n", lhsIndex, rhsIndex);
                break;
            } else if ((lhsIndex == 0 || rhsIndex == input.length - 1)) {
                System.out.println("This Numbers lhs, rhs can't be matched");
                break;
            }

            if (direction == "left") {
                lhsIndex--;
                rhsIndex--;
            } else if (direction == "right") {
                lhsIndex++;
                rhsIndex++;
            }

            lhsSum = lhsSum(input, lhsIndex);
            rhsSum = rhsSum(input, rhsIndex);

        }


    }

    private static String findDirection(int lhsSum, int rhsSum) {

        if (lhsSum > rhsSum) {
            return "left";
        } else if (lhsSum < rhsSum) {
            return "right";
        } else {
            return "stay";
        }
    }


    private static int lhsSum(int[] input, int toIndex) {
        return sum(input, 0, toIndex);
    }

    private static int rhsSum(int[] input, int fromIndex) {
        return sum(input, fromIndex, input.length - 1);
    }

    private static int sum(int[] input, int fromIndex, int toIndex) {
        int finalSum = 0;
        for (int i = fromIndex; i <= toIndex; i++) {
            finalSum += input[i];
        }

        return finalSum;
    }

}
