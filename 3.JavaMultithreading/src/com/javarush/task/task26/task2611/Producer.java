package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
/*1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ — счетчик начиная с 1, значение — фраза: «Some text for i» , пример «Some text for 1«.
2. при возникновении исключения выводить в консоль: «[TREAD_NAME] thread was terminated«, пример «[thread-1] thread was terminated«.*/
public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;
        while(true)
            try {
                map.put(String.valueOf(i), String.valueOf("Some text for " + i++));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " thread was terminated");
            }
    }
}