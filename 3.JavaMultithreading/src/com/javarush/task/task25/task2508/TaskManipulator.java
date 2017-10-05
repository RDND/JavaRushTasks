package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    private String threadName;

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        this.threadName = threadName;
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                System.out.println(threadName);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {}
    }
}
