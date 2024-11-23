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

    @Test
    void test3() {
        int n = 3;
        int x = 7;
        long result = x;
        //  keeps track of how many bits we still need to process (n-1)
        long remaining = n - 1;
        //  helps us check individual bits, starting from rightmost (1)
        long position = 1;

        while (remaining != 0) {
            if ((x & position) == 0) {
                result |= (remaining & 1) * position;
                remaining >>= 1;
            }
            position <<= 1;
        }
        System.out.println(result);
    }

    @Test
    void test4() {
        int sum = 0;
//        int[] nums = new int[] {1,2,14,3,10,15,8};
        int[] nums = new int[] {1,2,3,8};
        int res = nums.length;

        for (int num : nums) {
            sum = (sum | num);
        }
        System.out.println(sum);

        int i = 0, j = nums.length - 1;
        int tmp = 0;

//        while () {
//            sum -= (sum & num);
//            System.out.println(sum);
//        }
        System.out.println(sum);
    }

    private int square(int a, int b, int d) {
        return d * Math.min(a, b);
    }
}
