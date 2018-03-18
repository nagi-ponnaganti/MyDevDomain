package com.nagihome.codility.l4;

    import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args) {
        System.out.println("solution: " + Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    public static int[] solution(int N, int[] A) {

        int[] output = new int[N];

        for (int i = 0; i < A.length; i++) {

            if (A[i] > 0 && A[i] <= N) {
                output[A[i] - 1] += 1;
            } else if (A[i] == N + 1) {
                int maxNum = Integer.MIN_VALUE;
                for(int k: output){
                    if(maxNum < k)
                        maxNum = k;
                }
                Arrays.fill(output, maxNum);
            } else {
                throw new RuntimeException("Not a good input");
            }
        }

        return output;
    }

}
