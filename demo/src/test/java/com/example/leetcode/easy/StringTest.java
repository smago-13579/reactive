package com.example.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class StringTest {

    @Test
    void reverseString() {
        Character[] s = {'a', 'b', 'c', 'd', 'e', 'f'};
        Arrays.parallelSort(s , Comparator.reverseOrder());
        System.out.println(Arrays.toString(s));

        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
        String str = new StringBuilder(String.valueOf(arr)).reverse().toString();
        System.out.println(Arrays.toString(str.toCharArray()));
    }

    @Test
    void reverseInteger() {
        int i = -123;
        int j = -1463847413;
        System.out.println(reverseInteger(i));
        System.out.println(reverseInteger(j));
    }

    int reverseInteger(int i) {
        int res = 0;

        while (i != 0) {
            int digit = i % 10;

            if (digit > 0 && (Integer.MAX_VALUE - digit) / 10 < res) {
                return 0;
            } else if (digit < 0 && (Integer.MIN_VALUE - digit) / 10 > res) {
                return 0;
            }
            res = res * 10 + digit;
            i /= 10;
        }
        return res;
    }
}
