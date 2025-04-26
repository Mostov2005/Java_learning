package org.knit.solutions.TaskSem2;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.knit.solutions.ClassesSem2.lab5.task14.*;

/**
 * Задача 17: Реализация и проверка парадокса Монти Холла
 * <p>
 * Описание:
 * - Участник выбирает одну из трёх дверей.
 * - Ведущий открывает одну из оставшихся дверей, за которой нет приза.
 * - Участник может либо сменить выбор, либо оставить его неизменным.
 * <p>
 * Требования:
 * - Реализовать симуляцию игры на Java.
 * - Провести большое количество экспериментов (например, 1 000 000).
 * - Подсчитать вероятность выигрыша в каждом из двух случаев.
 * <p>
 * Ожидаемый результат:
 * - Вероятность выигрыша при смене выбора ≈ 66.66% (2/3).
 * - Вероятность выигрыша без смены ≈ 33.33% (1/3).
 */


@TaskDescription(taskNumber = 14,
        taskDescription = "Паттерн Визитер (Visitor)",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_14 implements Solution {
    public void execute() {
        File file1 = new File("file1.txt", 500, false);
        File file2 = new File("file2.exe", 1000, true);
        File file3 = new File("file3.jpg", 750, false);

        Folder folder = new Folder("Documents");
        folder.addElement(file1);
        folder.addElement(file2);
        folder.addElement(file3);

        Shortcut shortcut = new Shortcut(file1);

        Folder root = new Folder("Root");
        root.addElement(folder);
        root.addElement(shortcut);

        System.out.println("Cканер вирусов: ");
        VirusScanner virusScanner = new VirusScanner();
        root.accept(virusScanner);

        System.out.println("Размер файлов: ");
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();
        root.accept(sizeAnalyzer);
        System.out.println("Общий размер файлов: " + sizeAnalyzer.getTotalSize() + " байт");
    }
}