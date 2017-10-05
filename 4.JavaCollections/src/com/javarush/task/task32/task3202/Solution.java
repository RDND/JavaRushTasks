package com.javarush.task.task32.task3202;

import java.io.*;

/*
Читаем из потока
Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter,
содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
Требования:
1. Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.
2. Метод getAllDataFromInputStream (InputStream) должен возвращать StringWriter.
3. Метод getAllDataFromInputStream (InputStream) должен вернуть StringWriter, который содержит все данные из переданного потока.
4. Возвращаемый объект ни при каких условиях не должен быть null.
*/
public class Solution{

    public static StringWriter getAllDataFromInputStream(InputStream inputStream){
        StringWriter writer = new StringWriter();
        try {
            while(inputStream.available() > 0) {
                byte[] buff = new byte[1024];
                int len = inputStream.read(buff);
                writer.append(new String(buff, 0, len));
            }
        } catch (IOException e) {
            return writer;
        }
        return writer;
    }
    public static void main(String[] args) throws FileNotFoundException {
        StringWriter str = getAllDataFromInputStream(new FileInputStream("G:\\RDNDJV\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task32\\task3202\\temp.txt"));
        System.out.println(str.toString());
    }
}