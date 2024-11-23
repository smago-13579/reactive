package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

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

    @Test
    void test2() {
//        int[][] items = new int[][] {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[][] items = new int[][] {{193,732},{781,962},{864,954},{749,627},{136,746}};
        int[] queries = new int[] {1,2,3,4,5,6};
        int[] ans = new int[queries.length];
        var map = new TreeMap<Integer, Integer>();

        for (int[] item : items) {
            var entry = map.floorEntry(item[0]);

            if (entry == null || entry.getValue() < item[1]) {
                map.put(item[0], item[1]);
                entry = map.higherEntry(item[0]);

                while (entry != null && entry.getValue() < item[1]) {
                    map.remove(entry.getKey());
                    entry = map.higherEntry(item[0]);
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            var entry = map.floorEntry(queries[i]);
            int b = (entry == null) ? 0 : entry.getValue();
            ans[i] = b;
        }
    }

    private char[] intToCharArray(int num, char l) {
        return String.valueOf(num).toCharArray();
    }
}
