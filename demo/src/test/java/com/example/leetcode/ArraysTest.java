package com.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Stream;

public class ArraysTest {

    @ParameterizedTest
    @MethodSource("test1Data")
    void test1(int n, int[] arr, int expected) {
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (solve(n, arr, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        Assertions.assertEquals(expected, ans);
    }

    private boolean solve(int n, int[] quantities, int item) {
        if (item == 0) return false;
        int store = 0;

        for (int product : quantities) {
            store += (product - 1) / item + 1;

            if (store > n) {
                return false;
            }
        }
        return true;
    }

    static Stream<Arguments> test1Data() {
        return Stream.of(
                Arguments.of(6, new int[]{11, 6}, 3),
                Arguments.of(7, new int[]{15, 10, 10}, 5),
                Arguments.of(1, new int[]{100000}, 100000),
                Arguments.of(6, new int[]{10, 7}, 4),
                Arguments.of(6, new int[]{8, 5, 4}, 4),
                Arguments.of(6, new int[]{7, 5, 5}, 4),
                Arguments.of(3, new int[]{1, 1, 7}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("test2Data")
    void test2(int[] arr, int expected) {
        int left = 0;
        int right = arr.length - 1;
        int n = arr.length;

        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        /* for leetcode */
        /*if (left + 1 == n) {
            return 0;
        }*/

        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        int result = Math.min(right, n - left - 1);
        int i = 0;

        while (i <= left && right < n) {
            if (arr[i] <= arr[right]) {
                result = Math.min(result, right - i - 1);
                i++;
            } else {
                right++;
            }
        }
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> test2Data() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 10, 4, 2, 3, 5}, 3),
                Arguments.of(new int[]{1, 2, 3, 10, 4, 5, 6}, 1),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 4),
                Arguments.of(new int[]{1, 2, 3}, 0),
                Arguments.of(new int[]{1, 2, 3, 10, 0, 7, 8, 9}, 2),
                Arguments.of(new int[]{6,3,10,11,15,20,13,3,18,12}, 8)
        );
    }

    /**
     *  (product - 1) / item + 1 == Math.ceil(product / item)
     *  Remember this
     */
    @Test
    void simpleTest() {
        int res = 0;

        for (int product = 5, item = 2; product < 50; product *= 2, item *= 2) {
            res = (product - 1) / item + 1;

            System.out.println(res);
        }
    }

    @ParameterizedTest
    @MethodSource("test3Data")
    void test3(int[] nums, int k, int expected) {
        int size = test3Func(nums, k);

        System.out.println(size);
        Assertions.assertEquals(expected, size);
    }

    int test3Func(int[] nums, int k) {
        int n = nums.length;
        int size = Integer.MAX_VALUE;
        var deque = new LinkedList<Integer>();
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                size = Math.min(size, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return size == Integer.MAX_VALUE ? -1 : size;
    }

    static Stream<Arguments> test3Data() {
        return Stream.of(
                Arguments.of(new int[]{17, 85, 93, -45, -21}, 150, 2),
                Arguments.of(new int[]{2, -1, 2}, 3, 3),
                Arguments.of(new int[]{-40,-25,32,-19,61,45,50,83,79,74,-11,
                        62,23,49,47,21,94,24,-19,90}, 236, 3),
                Arguments.of(new int[]{-36,10,-28,-42,17,83,87,79,51,-26,33,
                        53,63,61,76,34,57,68,1,-30}, 484, 9),
                Arguments.of(new int[]{84, -37, 32, 40, 95}, 167, 3)
        );
    }
}
