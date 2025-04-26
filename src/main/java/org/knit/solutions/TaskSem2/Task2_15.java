package org.knit.solutions.TaskSem2;

import org.knit.solutions.Solution;
import org.knit.TaskDescription;
import org.knit.solutions.ClassesSem2.lab5.task15.*;

/**
 * Задача 15: Паттерн Прокси (Proxy) для удалённой библиотеки изображений
 * <p>
 * Описание:
 * - При запросе изображения оно загружается с сервера (симулируется задержкой).
 * - Изображение представляется классом RealImage.
 * - Прокси-объект ImageProxy лениво загружает изображение и кэширует его.
 * <p>
 * Требования:
 * - Реализовать класс RealImage для представления реального изображения.
 * - Реализовать класс ImageProxy для отложенной загрузки и кеширования.
 * - При повторном запросе загруженное изображение должно использоваться из кеша.
 */


@TaskDescription(taskNumber = 15,
        taskDescription = "Паттерн Прокси (Proxy)",
        href = "org/knit/solutions/taskExampleClasses/README.md")

public class Task2_15 implements Solution {
    public void execute() {
        Image image1 = new ImageProxy("image1.png");
        Image image2 = new ImageProxy("image2.jpg");

        System.out.println("Первый запрос к image1:");
        image1.display(); // Долгая загрузка (3 сек) перед созданием объекта

        System.out.println("\nВторой запрос к image1:");
        image1.display(); // Мгновенное отображение из кэша

        System.out.println("\nЗапрос к image2:");
        image2.display(); // Долгая загрузка (3 сек) перед созданием объекта
        image2.display();
    }
}
