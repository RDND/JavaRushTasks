package com.javarush.task.task23.task2305;

/* Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution_array = new Solution[2];

        for (int i = 0; i < 2; i++) {
            solution_array[i] = new Solution();
            for (int j = 0; j < 2; j++)
                solution_array[i].innerClasses[j] = solution_array[i].new InnerClass();
        }
        return solution_array;
    }

    public static void main(String[] args) {

    }
}
