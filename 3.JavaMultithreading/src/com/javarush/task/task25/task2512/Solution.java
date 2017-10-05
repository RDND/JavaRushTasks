package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/* В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> arrayThrowable = new ArrayList<>();
        arrayThrowable.add(e);
        Throwable throwable = e.getCause();
        while (throwable != null) {
            arrayThrowable.add(throwable);
            throwable = throwable.getCause();
        }
        for (int i = arrayThrowable.size() - 1; i >= 0; i--) {
            Throwable thr = arrayThrowable.get(i);
            System.out.println(thr.getClass().getName() + ": " + thr.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}
