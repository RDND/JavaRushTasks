package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать массив компараторов.
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.
Убежденному убеждать других не трудно
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }
        @Override
        public int compare(T o1, T o2) {
            int dif = 0;
            for (Comparator<T> comparator: comparators) {
                dif = comparator.compare(o1, o2);
                if (dif != 0) return dif;
            }
            return dif;
        }
    }

    public static void main(String[] args) {

    }
}
