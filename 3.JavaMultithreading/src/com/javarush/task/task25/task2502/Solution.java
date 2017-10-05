package com.javarush.task.task25.task2502;

import java.util.*;

/* Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.

Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            /*String[] strArray = loadWheelNamesFromDB();
            if (strArray.length !=4)
                throw new IllegalArgumentException();
            else
                for (String str: strArray)
                    wheels.add(Wheel.valueOf(str));*/
            if (loadWheelNamesFromDB().length != 4){
                throw new  IllegalArgumentException();
            }else {
                wheels = new ArrayList<>();
                for (String str : loadWheelNamesFromDB()) {
                    wheels.add(Wheel.valueOf(str));
                }
            }



            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
