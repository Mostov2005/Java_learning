package org.knit.solutions.ClassesSem2.lab5.task14;

public class File implements FileSystemElement {
    private final String name;
    private final int size;
    private final boolean hasVirus;

    public File(String name, int size, boolean hasVirus) {
        this.name = name;
        this.size = size;
        this.hasVirus = hasVirus;
    }

    public int getSize() {
        return size;
    }

    public boolean hasVirus() {
        return hasVirus;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}

