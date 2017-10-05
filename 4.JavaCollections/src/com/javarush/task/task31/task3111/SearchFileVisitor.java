package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*public class MyFileVisitor extends SimpleFileVisitor<Path> {
    String partOfName;
    String partOfContent;

@Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        if(partOfName!=null && !file.getFileName().toString().contains(partOfName))
            containsName = false;

        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if(partOfContent!=null && !content.contains(partOfContent))
            containsContent = false;

        if(containsName && containsContent)
            foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }
    Продвинутый поиск файлов
        Давай реализуем настраиваемый поиск файлов в директории.
        Просмотри интерфейс java.nio.file.FileVisitor и его базовую реализацию java.nio.file.SimpleFileVisitor.
        Во время поиска по дереву файлов с помощью метода Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)
        мы используем объект FileVisitor для выполнения необходимых операций над найденными объектами и.

        Наш класс для поиска будет называться SearchFileVisitor и расширять SimpleFileVisitor.

        Поиск можно будет выполнять по таким критериям:
        — выражение, встречающееся в названии файла (String);
        — выражение, встречающееся в содержимом файла (String);
        — максимальный и минимальный размер файла (int).
        Можно задавать либо один, либо сразу несколько критериев для поиска.

        Я в main написал код, который использует готовый SearchFileVisitor для поиска файлов, тебе осталась совсем легкая задача — выполнить его реализацию.
        Подсказка 1: методы get… , set… — это геттеры и сеттеры полей.
        Основная логика класса по поиску выполняется в методе visitFile(Path file, BasicFileAttributes attrs).
        Подсказка 2: для работы с файлами используй только классы из пакета java.nio.*/
public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles(){
        return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean contentName = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            contentName = false;
        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if (partOfContent != null && !content.contains(partOfContent))
            containsContent = false;
        boolean min = true;
        if (minSize != -1 && file.toFile().length() < minSize)
            min = false;
        boolean max = true;
        if (maxSize != -1 && file.toFile().length() > maxSize)
            max = false;
        if (contentName && containsContent && min && max)
            foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }
}
