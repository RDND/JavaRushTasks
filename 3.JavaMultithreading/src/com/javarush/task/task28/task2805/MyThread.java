package com.javarush.task.task28.task2805;


/*2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть больше максимального приоритета его трэд-группы.*/

public class MyThread extends Thread{
    private static int count;
    private int id = ++count;

    public void setPriority(){
        /*int priority = (id - 1) % 10;
        int max_priority = Thread.currentThread().getThreadGroup().getMaxPriority();
        if (priority > max_priority)
            priority = max_priority;
        this.setPriority(priority);*/
        int priority = id % 10;
        if (priority == 0) priority = 10;
        int maxPriority = Thread.currentThread().getThreadGroup().getMaxPriority();
        if (priority > maxPriority) priority = maxPriority;
        this.setPriority(priority);
    }

    public MyThread(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
        setPriority();
    }

    public MyThread() {
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }
}