package org.knit.solutions.ClassesSem2.lab5.task15;

class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        System.out.println("Объект RealImage создан для: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения: " + filename);
    }
}
