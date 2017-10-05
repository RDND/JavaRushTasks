package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять «n«.
Все файлы имеют расширение txt.


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Пройдись по всем файлам в директории, которая приходит первым параметром в main, и всех ее поддиректориях.
Файлы с размером более 50 байт нужно удалить используя метод FileUtils.deleteFile.
4. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
5. Поток для записи в файл нужно закрыть.
Проход по дереву файлов
*/
public class Solution {

    

    public static void main(String[] args) throws IOException {
        //String directoryPath = args[0];
        //String resultFileAbsolutePath = args[1];
        String directoryPath = "temp";
        String resultFileAbsolutePath = "temp/res.txt";
        String allFilesContent = "allFilesContent.txt";


        /*saveFilesLessThan50Bytes(directoryPath);

        // rename file
        Path source = Paths.get(resultFileAbsolutePath);
        Path newResPath = Files.move(source, source.resolveSibling(allFilesContent));

        // delete resultFileAbsolutePath if list contains it
        lessThan50BytesFiles.remove(new File(resultFileAbsolutePath));

        // sort file by name
        Collections.sort(lessThan50BytesFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();
                return fileName1.compareTo(fileName2);
            }
        });

        // write to result file
        BufferedWriter fout = new BufferedWriter(new FileWriter(newResPath.toFile()));
        for (File file : lessThan50BytesFiles) {
            BufferedReader fin = new BufferedReader(new FileReader(file));
            while (fin.ready()) {
                fout.write(fin.readLine());
                fout.newLine();
            }
            fin.close();
        }
        fout.close();
    }

    private static List<File> lessThan50BytesFiles = new ArrayList<>();

    private static void saveFilesLessThan50Bytes(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles();

        if (files == null) {
            // it is not directory
            return;
        } else if (files.length == 0) {
            // directory is empty
            dir.delete();
        } else {
            for (File file : files) {
                if (file.isDirectory()) {
                    // nested directory
                    saveFilesLessThan50Bytes(file.getAbsolutePath());
                } else {
                    if (file.length() > 50) {
                        file.delete();
                    } else {
                        lessThan50BytesFiles.add(file);
                    }
                }
            }
        }*/
    }
}
