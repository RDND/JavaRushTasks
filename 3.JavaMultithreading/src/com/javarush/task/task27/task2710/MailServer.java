package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    final private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long beforeTime = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        try {
            synchronized (mail) {
                mail.wait();
                long afterTime = System.currentTimeMillis();
                System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
