package org.knit;

import org.junit.jupiter.api.Test;
import org.knit.solutions.ClassesSem2.lab6.Merge;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeTest {
    @Test
    void testRegularCase() {
        Merge solution = new Merge();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
    }

    @Test
    void testNoElementsInNums2() {
        Merge solution = new Merge();
        int[] nums1 = {1};
        int[] nums2 = {};
        solution.merge(nums1, 1, nums2, 0);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void testNoElementsInNums1() {
        Merge solution = new Merge();
        int[] nums1 = {0};
        int[] nums2 = {1};
        solution.merge(nums1, 0, nums2, 1);
        assertArrayEquals(new int[]{1}, nums1);
    }

    @Test
    void testNegativeNumbers() {
        Merge solution = new Merge();
        int[] nums1 = {-3, -2, -1, 0, 0, 0};
        int[] nums2 = {-2, 0, 1};
        solution.merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[]{-3, -2, -2, -1, 0, 1}, nums1);
    }

    @Test
    void testPerformance() {
        Merge solution = new Merge();
        int size = 200;
        int[] nums1 = new int[size * 2];
        int[] nums2 = new int[size];
        for (int i = 0; i < size; i++) {
            nums1[i] = i;
            nums2[i] = i;
        }
        long startTime = System.nanoTime();
        solution.merge(nums1, size, nums2, size);
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) / 1e6 + " ms"); // 0.0180 ms в среднем
    }
}
