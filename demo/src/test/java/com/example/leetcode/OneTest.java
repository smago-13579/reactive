package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class OneTest {

    @Test
    void test() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int j = 0;
        char l = ' ';
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (l == chars[i]) {
                count++;
            } else if (count > 0) {
                chars[j++] = l;
                l = chars[i];

                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[j++] = c;
                    }
                }
                count = 1;
            } else {
                l = chars[i];
                count++;
            }
        }
        chars[j++] = l;

        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[j++] = c;
            }
        }
        System.out.println(chars);
        System.out.println(j);
    }

    private char[] intToCharArray(int num, char l) {
        return String.valueOf(num).toCharArray();
    }
}
