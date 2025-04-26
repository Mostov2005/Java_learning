package org.knit.solutions.ClassesSem2.lab6;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Указатель на последний значимый элемент в nums1
        int j = n - 1;  // Указатель на последний элемент в nums2
        int k = m + n - 1; // Указатель на позицию вставки в nums1

        // Заполняем nums1 с конца
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Если в nums2 остались элементы, переносим их в nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
