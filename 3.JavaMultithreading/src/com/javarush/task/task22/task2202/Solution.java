package com.javarush.task.task22.task2202;

/* Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример:
«JavaRush — лучший сервис обучения Java.»
Результат:
«— лучший сервис обучения»
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        //System.out.println(getPartOfString("JavaRush - лучший сервис обучения"));
    }

    public static String getPartOfString(String string) {
        /*int begin = string.indexOf(' ');
        int end = begin;
        for (int i = 0; i < 4; i++)
            end = string.indexOf(' ', end + 1);
        if (end == -1) throw new TooShortStringException();
        return string.substring(begin + 1, end);*/
        if (string == null)
            throw new TooShortStringException();
        String[] array = string.split(" ");
        if (array.length < 5)
            throw new TooShortStringException();
        return array[1] + " " + array[2] + " " + array[3] + " " + array[4];
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
