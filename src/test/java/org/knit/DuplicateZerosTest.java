package org.knit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.knit.solutions.ClassesSem2.lab6.DuplicateZeros;

class DuplicateZerosTest {
    @Test
    void testRegularCase() {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        new DuplicateZeros().duplicateZeros(arr);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, arr);
    }

    @Test
    void testNoZeros() {
        int[] arr = {1, 2, 3};
        new DuplicateZeros().duplicateZeros(arr);
        assertArrayEquals(new int[]{1, 2, 3}, arr);
    }

    @Test
    void testAllZeros() {
        int[] arr = {0, 0, 0, 0};
        new DuplicateZeros().duplicateZeros(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0}, arr);
    }

    @Test
    void testZerosAtBorders() {
        int[] arr = {0, 1, 2, 3, 4, 0};
        new DuplicateZeros().duplicateZeros(arr);
        assertArrayEquals(new int[]{0, 0, 1, 2, 3, 4}, arr);
    }


    @Test
    void testLargeArrayPerformance() {
        int size = 10000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (i % 5 == 0) ? 0 : 1;
        }
        long startTime = System.nanoTime();
        new DuplicateZeros().duplicateZeros(arr);
        long endTime = System.nanoTime();
        System.out.println("Время выполнения: " + (endTime - startTime) / 1e6 + " ms"); // 1.2 ms в среднем
    }
}