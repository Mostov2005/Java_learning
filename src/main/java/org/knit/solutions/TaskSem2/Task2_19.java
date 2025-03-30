package org.knit.solutions.TaskSem2;


import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab6.Merge;
import org.knit.solutions.Solution;

import java.util.Arrays;

/**
 * Задача 18: Дублирование нулей в массиве
 * <p>
 * Описание:
 * - Необходимо продублировать каждое вхождение нуля в массиве.
 * - При этом элементы сдвигаются вправо, а выходящие за границы отбрасываются.
 * - Изменения выполняются на месте без создания нового массива.
 * <p>
 * Требования:
 * - Реализовать метод duplicateZeros(int[] arr) для модификации массива in-place.
 * - Написать JUnit тесты для проверки работы метода:
 * - Обычные случаи (с нулями и без).
 * - Краевые случаи (пустые массивы, все нули, нули на границах).
 * - Производительность (большие массивы, замер времени выполнения).
 */


@TaskDescription(taskNumber = 19,
        taskDescription = "JUnit тесты для проверки слияния двух отсортированных массивов",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_19 implements Solution {
    public void execute() {
        Merge merge = new Merge();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge.merge(nums1, m, nums2, n);
        System.out.println("Merged array: " + Arrays.toString(nums1));
    }
}
