package com.example.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysTest {

    @ParameterizedTest
    @MethodSource("rotateArrayData")
    void rotateArray(int[] nums, int k, int[] result) {
        int n = nums.length;
        k = k % n;
        int[] copy = new int[n];

        for (int i = 0; i < n; i++) {
            int index = (i + k) % n;
            copy[index] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = copy[i];
        }
        Assertions.assertEquals(Arrays.toString(nums), Arrays.toString(result));
    }

    static Stream<Arguments> rotateArrayData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6,7}, 3, new int[]{5,6,7,1,2,3,4})
        );
    }
}
