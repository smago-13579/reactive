package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    void HashMapTest() {
        HashMap<Long, Long> map = new HashMap<>();
        System.out.println(1 << 30);
        map.put(1L, 1L);
        System.out.println(map.get(1L));
    }

    @Test
    void binaryTest() {
        printBinary(2147483647);
        printBinary(-2147483648);
        printBinary(-2147483647);
        printBinary(8);
        printBinary(-8);
        printBinary(-8 >> 1);

        int number = -2; // In binary: 11111111 11111111 11111111 11111110

        System.out.println("Original number: " + number);
        System.out.println("Binary representation:");
        printBinary(number);

        // Shift right by 1 position
        int shiftedNumber = number >>> 1;
        System.out.println("\nAfter >>> 1:");
        printBinary(shiftedNumber);

        // Shift right by 2 positions
        shiftedNumber = number >>> 2;
        System.out.println("\nAfter >>> 2:");
        printBinary(shiftedNumber);
    }

    public static void printBinary(int number) {
        String binary = String.format("%32s", Integer.toBinaryString(number))
                .replace(' ', '0');
        // Print with spaces for readability
        for (int i = 0; i < 32; i += 8) {
            System.out.print(binary.substring(i, i + 8) + " ");
        }
        System.out.println();
    }
}
