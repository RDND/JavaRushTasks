package com.javarush.task.task29.task2912;

abstract public class AbstractLogger implements Logger{
    private int level;
    private Logger next;

    public AbstractLogger(int level) {
        this.level = level;
    }

    @Override
    public void setNext(Logger next) {
        this.next = next;
    }

    abstract public void info(String message);

    @Override
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }
}