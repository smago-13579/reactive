package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class TwoTest {

    @Test
    void test() {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};

        int i = 0;
        int j = arr.length - 1;
        int sum = 0;

        while (i < j) {
            int sq = square(arr[i], arr[j], j - i);

            if (sq > sum) {
                sum = sq;
            }

            if (arr[i] > arr[j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(sum);
    }

    @Test
    void test2() {
        int[] arr = new int[]{125,92,159};

        for (int i : arr) {
            System.out.println(Integer.bitCount(i));
        }
    }

    private int square(int a, int b, int d) {
        return d * Math.min(a, b);
    }
}
