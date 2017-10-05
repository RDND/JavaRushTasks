package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.abs;

/* Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
            Arrays.sort(array);
            double m;
            int size = array.length;
            if (size %2 == 0)
                m = (array[size/2] + array[size/2-1])/2;
            else m = array[(size - 1)/2];
            Comparator<Integer> comparator = new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    double value = Math.abs(o1 - m) - Math.abs(o2 - m);
                    if (value == 0)
                        value = o1 - o2;
                    return (int) value;
                }

        };
        Arrays.sort(array, comparator);

        //implement logic here
        return array;
    }
}
