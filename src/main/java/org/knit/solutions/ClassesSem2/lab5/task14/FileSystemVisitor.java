package org.knit.solutions.ClassesSem2.lab5.task14;

interface FileSystemVisitor {
    void visit(File file);

    void visit(Folder folder);

    void visit(Shortcut shortcut);
}
