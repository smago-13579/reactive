package com.example.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class ArraysTest {

    @ParameterizedTest
    @MethodSource("rotateArrayData")
    void rotateArray(int[] nums, int k, int[] result) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        Assertions.assertEquals(Arrays.toString(nums), Arrays.toString(result));
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @ParameterizedTest
    @MethodSource("containsDuplicateData")
    void containsDuplicate(int[] nums, boolean expected) {
        var set = new HashSet<>();
        boolean result = false;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result = true;
                break;
            }
            set.add(nums[i]);
        }
        Assertions.assertEquals(expected, result);
    }

    @Test
    void singleNumber() {
        int[] nums = {4,1,2,1,2};
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        System.out.println(res);
    }

    static Stream<Arguments> containsDuplicateData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,1}, true)
        );
    }

    static Stream<Arguments> rotateArrayData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6,7}, 3, new int[]{5,6,7,1,2,3,4})
        );
    }

    @Test
    void intersectionOfTwoArrays() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                result.add(nums2[i]);
                int val = map.get(nums2[i]) - 1;

                if (val == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], val);
                }
            }
        }
        int[] arr = result.stream().mapToInt(x -> x).toArray();
    }

    @Test
    void plusOne() {
//        int[] digits = {4,3,2,1};
        int[] digits = {9};
        int n = digits.length;
//        int[] res;

        int i = n - 1;

        while (i >= 0 && digits[i] == 9) {
            i--;
        }

        if (i < 0) {
            int[] res = new int[n + 1];
            res[0] = 1;

            for (i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            System.out.println(Arrays.toString(res));
        } else {
            digits[i]++;
            i++;

            for (;i < digits.length; i++) {
                digits[i] = 0;
            }
            System.out.println(Arrays.toString(digits));
        }
    }

    @Test
    void rotateImage() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int start = 0;
        int end = matrix.length - 1;

        while (start < end) {
            for (int i = start, j = start; i < end; i++) {
                rotate(i, j, matrix);
            }
            start++;
            end--;
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    void rotate(int i, int j, int[][] matrix) {
        int n = matrix.length - 1;
        int tmp = matrix[i][j];

        matrix[i][j] = matrix[n - j][i];
        matrix[n - j][i] = matrix[n - i][n - j];
        matrix[n - i][n - j] = matrix[j][n - i];
        matrix[j][n - i] = tmp;
    }
}
