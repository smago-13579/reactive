package com.example.demo;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Stream;

public class GTest {

    @Test
    void test() {
        int[] arr = new int[] {1,12,32,35,44,57};
        int i = Arrays.binarySearch(arr, 1);
        System.out.println(i);
        "".isBlank();

    }

    @Test
    void test2() {
        Path path = Paths.get("/Users/smago");

        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path tmp : files) {
                if (!Files.isDirectory(tmp)) {
                    if (tmp.getFileName().toString().equals("1")) {
                        System.out.println(true);
                    }
                } else {

                }
            }
        } catch (IOException e) {
            System.out.println("Exception in method: directorySize");
            System.out.println(e.getMessage());
        }
    }

    @Test
    void test3() {

    }

    @Test
    void test4() {

    }

    @Test
    void test5() {

    }
}
