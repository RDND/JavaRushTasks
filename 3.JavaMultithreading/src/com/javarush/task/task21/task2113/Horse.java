package com.javarush.task.task21.task2113;
/*Теперь вернемся к лошадям. У каждой лошади на скачках должны быть известны имя (name) и скорость (speed).
Наши лошади будут бежать просто определенное время (100 секунд/»шагов»).
Будем определять победителя, как лошадь, пробежавшую наибольшую дистанцию.
Поэтому нам понадобится хранить еще и расстояние (distance), которое лошадь уже пробежала.
Добавь в класс Horse переменные name (String), speed (double), distance (double).

Требования:
1. В классе Horse должно быть создано поле name.
2. В классе Horse должно быть создано поле speed.
3. В классе Horse должно быть создано поле distance.
4. Поле name должно быть типа String.
5. Поле speed должно быть типа double.
6. Поле distance должно быть типа double.

Закончим написание класса лошадь (Horse).
Добавь конструктор с параметрами (name, speed, distance).
Добавь getter’ы и setter’ы для всех полей класса Horse.
Делай все методы public, если явно не указано обратное.

1. В методе move класса Horse значение поля distance должно увеличиваться на расстояние пройденное за
один "ход"(значение поля speed) умноженное на случайное число от нуля до единицы полученное с помощью вызова метод Math.random().

1. Метод print должен выводить на экран строку состоящую из точек и имени лошади. Количество точек равно целой части distance.*/

public class Horse {
    public String name;
    public double speed;
    public double distance;
    public void move(){
        distance += speed*Math.random();
    }
    public void print(){
        for (int i = 0; i < distance - 1; i++)
            System.out.print(".");
        System.out.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
}