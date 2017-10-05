package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/*5.1. Усыпи трэд на 0.45 секунды.
5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль «Processing item.toString()».
 * Created by RDND on 12.07.2017.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
        }
        while(true){
            try {
                queue.take();
                System.out.format("Processing item.toString()");
            } catch (InterruptedException e) {
            }
        }

    }
}
