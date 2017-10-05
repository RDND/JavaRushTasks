package com.javarush.task.task25.task2504;

/* 1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.
Switch для нитей
public enum State
{
 NEW,
 RUNNABLE,
 BLOCKED,
 WAITING,
 TIMED_WAITING,
 TERMINATED;
}
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thread : threads) {

            Thread.State state = thread.getState();

            switch (state) {
                case NEW:
                    thread.start();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case BLOCKED:
                    thread.interrupt();
                    break;
                case WAITING:
                    thread.interrupt();
                    break;
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }

        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {


    }
}
