package com.javarush.task.task28.task2813;

import java.util.concurrent.Callable;
/* Класс FactorialCalculator предназначен для вычисления факториала числа переданного в его конструктор в качестве параметра.
К сожалению, он реализован некорректно и тебе необходимо это исправить.
*/
public class FactorialCalculator implements Callable {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws InterruptedException {
        return factorial(number);
        //return 0L;
    }

    public long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while (number > 1) {
            Thread.sleep(1);
            result = result * number;
            number--;
        }
        return result;
    }
}
