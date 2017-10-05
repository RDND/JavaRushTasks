package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
/*Метод get класса TransferObject должен устанавливать флаг isValuePresent в false
и уведомлять другие нити ожидающие освобождения монитора перед возвратом значение поля value.*/
        try {
            while (!isValuePresent)
                this.wait();
            System.out.println("Got: " + value);
            isValuePresent = false;
            this.notifyAll();
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return value;
        }

    }

    public synchronized void put(int value) {

        try {
            while(isValuePresent)
                this.wait();
            this.value = value;
            System.out.println("Put: " + value);
            isValuePresent = true;
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
