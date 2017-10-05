package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {}

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) { statisticStorage.put(data); }

    public void register(Cook cook) { cooks.add(cook); }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> map = new HashMap<>();
        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                map.put(type, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data) {
            map.get(data.getType()).add(data);
        }
        private List<EventDataRow> get(EventType eventType) {
            return map.get(eventType);
        }
    }


    public Map<Date, Double> getTotalMoneyPerDay() {
        Map<Date, Double> resultMap = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : statisticStorage.get(EventType.SELECTED_VIDEOS)) {
            Date date = dateWithoutTime(event.getDate());
            VideoSelectedEventDataRow eventData = (VideoSelectedEventDataRow) event;
            if (resultMap.containsKey(date)) {
                resultMap.put(date, resultMap.get(date) + (0.01d * (double) eventData.getAmount()));
            } else {
                resultMap.put(date, (0.01d * (double) eventData.getAmount()));
            }
        }
        return resultMap;
    }


    public Map<Date, TreeMap<String, Integer>> getCookWorkloading() {
        Map<Date, TreeMap<String, Integer>> result = new TreeMap<Date, TreeMap<String, Integer>>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.COOKED_ORDER);
        Date date;
        Calendar calendar;
        String cookName;
        int cookingTimeSeconds;
        for (EventDataRow eventDataRow : eventDataRowList) {
            CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) eventDataRow;
            calendar = Calendar.getInstance();
            calendar.setTime(cookedOrder.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            cookName = cookedOrder.getCookName();
            cookingTimeSeconds = cookedOrder.getTime();
            TreeMap<String, Integer> cookTime = new TreeMap<String, Integer>();
            if (result.containsKey(date)) {
                cookTime = result.get(date);
                if (cookTime.containsKey(cookName)) {
                    cookingTimeSeconds += cookTime.get(cookName);
                }
            }
            cookTime.put(cookName, cookingTimeSeconds);
            result.put(date, cookTime);
        }
        return result;
    }


    private Date dateWithoutTime(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}