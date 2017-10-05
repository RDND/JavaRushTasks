package com.javarush.task.task31.task3105;

/*Добавление файла в архив
        В метод main приходит список аргументов.
        Первый аргумент — полный путь к файлу fileName.
        Второй аргумент — путь к zip-архиву.
        Добавить файл (fileName) внутрь архива в директорию ‘new‘.
        Если в архиве есть файл с таким именем, то заменить его.
        Пример входных данных:
        C:/result.mp3
        C:/pathToTest/test.zip
        Файлы внутри test.zip:
        a.txt
        b.txt
        После запуска Solution.main архив test.zip должен иметь такое содержимое:
        new/result.mp3
        a.txt
        b.txt
        Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
        Пользоваться файловой системой нельзя.*/

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Solution{
    public static void main(String[] args) throws IOException {

        String zipFileName =
                "G:/temp/task31/task3102/Solution.java"
                //args[1]
        ;
        File file = new File(
                "G:/temp/task31/task3102/afaa.rar"
                //args[0]
        );


        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();
        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipReader.getNextEntry()) != null){
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bufer = new byte[1024];
                int count;

                while ((count = zipReader.read(bufer)) != -1)
                    byteArrayOutputStream.write(bufer, 0, count);

                System.out.println(zipEntry.getName());
                archivedFiles.put(zipEntry.getName(), byteArrayOutputStream);
            }
        }

        try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFileName))){
            for (Map.Entry<String, ByteArrayOutputStream> pair: archivedFiles.entrySet()){
                if(file.getName().equals(pair.getKey().lastIndexOf(File.separator)))
                    continue;
                zipWriter.putNextEntry(new ZipEntry(pair.getKey()));
                zipWriter.write(pair.getValue().toByteArray());
            }
            ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
            zipWriter.putNextEntry(new ZipEntry(zipEntry));
            Files.copy(file.toPath(), zipWriter);
        }
    }
}