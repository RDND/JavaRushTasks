package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
/*Несмотря на то что мы объявили переменную horses, сам список еще не создан (если ты конечно не успел опередить нас).
Создай конструктор класса Hippodrome с одним параметром типа List.
Сохрани в поле horses полученный в качестве параметра список (инициализируй поле horses).
Требования:
1. В классе Hippodrome должен быть создан конструктор с одним параметром типа List.
2. Должна существовать возможность создавать объекты типа Hippodrome извне класса с помощью оператора new.
3. Поле horses должно быть корректно инициализировано в конструкторе класса Hippodrome.

Теперь перейдем к классу Hippodrome и методу main.
Нам нужно создать объект типа Hippodrome и добавить ему несколько лошадей.

Для начала, в классе Hippodrome:
Создай статическое поле game типа Hippodrome.

В методе main требуется:
а) Создать объект типа Hippodrome и сохранить его в поле game.
б) Создать три объекта «лошадь«. Имена придумай сам. Начальные скорость у всех лошадей — 3, дистанция — 0.
в) Добавить созданных лошадей в список лошадей ипподрома (horses). Получить список лошадей ипподрома можно с помощью метода getHorses.

Но и это еще не все — надо чтобы лошади бежали.
Добавь в класс Hippodrome методы run, move и print. Без параметров.
Метод move будет управлять движением всех лошадей.
Метод print отрисовывать их на экран.
А метод run — управлять всем этим.

В методе run сделай цикл от 1 до 100. Это и будет наш забег.
В теле цикла вызываем сначала move, затем print.
Чтобы весь цикл не отработал за долю секунды — добавь в него еще Thread.sleep(200);

1. В классе Horse должен быть создан метод move.
2. В классе Horse должен быть создан метод print.
3. В методе move класса Hippodrome должен быть вызван метод move по одному разу для каждой лошади(каждого элемента списка horses).

Еще нужно написать метод print класса Hippodrome.
В нем тоже все просто: в цикле для каждой лошади вызываем ее метод print.
Ну, и еще выведи после цикла 10 пустых строк: System.out.println() — чтобы было красивее.

В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!*/
public class Hippodrome {
    static public Hippodrome game;
    private List<Horse> horses;
    public List<Horse> getHorses() {
        return horses;
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse hrs: getHorses()) {
            hrs.move();
        }
    }
    public void print(){
        for (Horse hrs: getHorses()) {
            hrs.print();
        }
        for (int i = 0; i<10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
        Horse hrs = null;
        double max = 0;
        for (Horse i: horses)
            if (max < i.getDistance()) {
            max = i.getDistance();
            hrs = i;
            }
            return hrs;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        //Horse horse1 = new Horse("horse1", 3, 0);
        //Horse horse2 = new Horse("horse2", 3, 0);
        //Horse horse3 = new Horse("horse3", 3, 0);
        //List<Horse> horses = new ArrayList<Horse>();
        game.getHorses().add(new Horse("horse1", 3, 0));
        game.getHorses().add(new Horse("horse2", 3, 0));
        game.getHorses().add(new Horse("horse3", 3, 0));
        game.run();
        game.printWinner();
    }
}