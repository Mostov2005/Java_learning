package org.knit.solutions.TaskSem2;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab6.DuplicateZeros;
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


@TaskDescription(taskNumber = 18,
        taskDescription = "JUnit тесты для проверки дублирования нулей в массиве",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_18 implements Solution {
    public void execute() {
        DuplicateZeros dz = new DuplicateZeros();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        System.out.println("До:  " + Arrays.toString(arr));
        dz.duplicateZeros(arr);
        System.out.println("После: " + Arrays.toString(arr));

        int[] arr2 = {1, 2, 3};
        System.out.println("До:  " + Arrays.toString(arr2));
        dz.duplicateZeros(arr2);
        System.out.println("После: " + Arrays.toString(arr2));

        int[] arr3 = {0, 1, 2, 3, 4, 0};
        System.out.println("До:  " + Arrays.toString(arr3));
        dz.duplicateZeros(arr3);
        System.out.println("После: " + Arrays.toString(arr3));
    }
}

