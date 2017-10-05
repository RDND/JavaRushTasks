package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper{

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        System.out.println("Выберите блюда. Для завершения наберите 'exit'.");
        System.out.println(Dish.allDishesToString());
        while (true) {
            String str = readString();
            if ("exit".equalsIgnoreCase(str))
                break;
            try{
                dishes.add(Dish.valueOf(str));
            } catch (Exception e){
                System.out.println(str + " is not detected");
            }
        }
        return dishes;
    }
}