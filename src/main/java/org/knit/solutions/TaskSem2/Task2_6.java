package org.knit.solutions.TaskSem2;


import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab2.task3.RailwayCrossing;
import org.knit.solutions.Solution;

/**
 * Задача 2.6: Железнодорожный переезд 🚆🚗
 * <p>
 * Описание:
 * - Автомобили движутся, но если поезд приближается, они останавливаются и ждут.
 * - После проезда поезда автомобили продолжают движение.
 * <p>
 * Требования:
 * - Поток "Поезд" останавливает автомобили (wait()).
 * - Поток "Поезд" сообщает о завершении движения (notifyAll()).
 * - Автомобили ждут, если поезд едет, и продолжают движение после notifyAll().
 */

@TaskDescription(taskNumber = 6,
        taskDescription = "Железнодорожный переезд",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_6 implements Solution {
    public void execute() {
        RailwayCrossing crossing = new RailwayCrossing();

        // Поток поезда (каждые 10 секунд)
        Thread train = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                crossing.arriveTrain();
            }
        });

        // Потоки машин (едут постоянно)
        for (int i = 1; i <= 5; i++) {
            String carName = "Машина " + i;
            new Thread(() -> {
                while (true) {
                    crossing.passCar(carName);
                    try {
                        Thread.sleep(5000); // Интервал движения машин
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }

        train.start();
    }
}
