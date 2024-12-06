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

    @Test
    void arraysTest() {
        int[] chars = new int[10];
        int[] chars2 = new int[11];
        int[] chars3 = new int[10];
        chars3[0] = 'a';

        System.out.println(chars.equals(chars));
        System.out.println(chars2.equals(chars));
        System.out.println(chars3.equals(chars));
        System.out.println(Arrays.equals(chars, chars2));
        System.out.println(Arrays.equals(chars, chars3));

    }

    @Test
    void atoiTest() {
        int res = atoi("-21474848");
        System.out.println(res);
    }

    private int atoi(String s) {
        int i = 0;
        String sign = "";

        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                sign += s.charAt(i);
                i++;
            } else {
                break;
            }
        }

        if (sign.length() > 1 || i == s.length()) {
            return 0;
        }
        boolean negative = sign.equals("-");
        int j = i;
        int result = 0;

        while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
            if (!negative && (Integer.MAX_VALUE - (s.charAt(j) - '0')) / 10 < result) {
                return Integer.MAX_VALUE;
            }

            if (negative && (Integer.MIN_VALUE + (s.charAt(j) - '0')) / 10 + result > 0) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(j) - '0');
            j++;
        }
        return negative ? -result : result;
    }
}
