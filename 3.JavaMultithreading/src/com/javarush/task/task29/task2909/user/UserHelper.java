package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    //private boolean isManAnya = false;
    //private boolean isManRoma = true;

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }


    public int calculateAverageAge() {
        User userUra = new User("Юра", "Карп", 28);

        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;

    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        AtomicInteger base1 = new AtomicInteger(base.get() + age / 100);
        base1.set((int) (base1.get() * (hasWork ? 1.1 : 0.9)));
        base1.set((int) (base1.get() * (hasHouse ? 1.1 : 0.9)));
        return (int) base1.longValue();
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}