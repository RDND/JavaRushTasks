package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waitor;

public class Restaurant {

    public static void main(String[] args) {

        Cook cook = new Cook("Amigo");
        Tablet tablet = new Tablet(5);
        Waitor waitor = new Waitor();

        cook.addObserver(waitor);
        tablet.addObserver(cook);
        tablet.createOrder();


        DirectorTablet directorTablet = new DirectorTablet();

        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();



        /*Cook cook2 = new Cook("Amigo2");
        cook2.addObserver(waitor);
        tablet.addObserver(cook2);
        tablet.createOrder();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();*/

    }

}