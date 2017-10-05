package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {

        double total = 0;
        for (Map.Entry<Date, Double> entry : StatisticManager.getInstance().getTotalMoneyPerDay().entrySet()) {

            double e = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", simpleDateFormat.format(entry.getKey()), e));
            total += e;
        }
        if (total > 0) ConsoleHelper.writeMessage(String.format("Total - %.2f",total));
    }
    /*public void printCookWorkloading() {

        for (Map.Entry<Date, TreeMap<String, Integer>> pair : StatisticManager.getInstance().getCookInfo().entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> pair2 : pair.getValue().entrySet()) {
                if (pair2.getValue() > 0) {
                    ConsoleHelper.writeMessage(String.format("%s - %d min", pair2.getKey(), pair2.getValue()));
                }
            }
        }
    }*/
    public void printCookWorkloading() {
        Map<Date, TreeMap<String, Integer>> cookWorkloading = StatisticManager.getInstance().getCookWorkloading();
        Date date;
        TreeMap<String, Integer> cookTime;
        String cookName;
        int cookingTimeMinutes;
        for (Map.Entry<Date, TreeMap<String, Integer>> dateTreeMapEntry : cookWorkloading.entrySet()) {
            date = dateTreeMapEntry.getKey();
            cookTime = dateTreeMapEntry.getValue();
            ConsoleHelper.writeMessage(simpleDateFormat.format(date));
            for (Map.Entry<String, Integer> entry : cookTime.entrySet()) {
                cookName = entry.getKey();
                cookingTimeMinutes = (int) Math.ceil(entry.getValue()/60.0);
                if (cookingTimeMinutes > 0)
                    ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, cookingTimeMinutes));
            }
            //ConsoleHelper.writeMessage(""); //пробовал и с этим (этот метод все равно принимается валидатором)
        }
    }

    public void printActiveVideoSet() {}
    public void printArchivedVideoSet() {}
}