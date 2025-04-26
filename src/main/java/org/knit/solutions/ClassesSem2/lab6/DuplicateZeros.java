package org.knit.solutions.ClassesSem2.lab6;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int countZeros = 0;

        // Считаем количество нулей, которые можно удвоить
        for (int k : arr) {
            if (k == 0) {
                countZeros++;
            }
        }

        int i = n - 1;
        int j = n + countZeros - 1;

        // Заполняем массив с конца, дублируя нули
        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            j--;

            if (arr[i] == 0) {
                if (j < n) {
                    arr[j] = 0;
                }
                j--;
            }
            i--;
        }
    }
}
