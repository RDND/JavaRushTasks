package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waitor implements Observer {

    @Override
    public void update(Observable observable, Object o)
    {
        if (o instanceof Order && observable instanceof Cook)
        {
            Cook cook = (Cook) observable;
            Order order = (Order) o;

            ConsoleHelper.writeMessage(order + " was cooked by " + cook);
        }
    }
}