package org.knit.solutions.ClassesSem2.lab5.task14;

public class Shortcut implements FileSystemElement {
    private final FileSystemElement target;

    public Shortcut(FileSystemElement target) {
        this.target = target;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}

