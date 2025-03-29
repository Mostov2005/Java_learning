package org.knit.solutions.TaskSem2;

import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab2.task6.Workshop;
import org.knit.solutions.Solution;

/**
 * Задача 2.9: Конвейер сборки деталей 🏭🔩
 * <p>
 * Описание:
 * - Штамповщик создает заготовку (объект детали).
 * - Сборщик собирает готовую деталь.
 * - Оператор контроля качества проверяет и отправляет на склад.
 * <p>
 * Требования:
 * - Каждый рабочий — отдельный поток.
 * - Использовать потоки (Thread или ExecutorService).
 * - Использовать синхронизацию (wait(), notify(), BlockingQueue).
 */

@TaskDescription(taskNumber = 9,
        taskDescription = "Конвейер сборки деталей",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_9 implements Solution {
    public void execute() {
        Workshop workshop = new Workshop();
        workshop.startProduction();
    }
}
