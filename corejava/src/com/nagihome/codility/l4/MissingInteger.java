package com.nagihome.codility.l4;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public static void main(String[] args) {
        System.out.println("Solution: " + solution(new int[]{-3, -1, 1, 2, 3, 5}));
    }

    public static int solution(int[] A) {

        Set<Integer> set = new HashSet<>();
        int num = 1;

        for (int i : A)
            set.add(i);

        while (set.contains(num))
            num++;

        return num;
    }

}
