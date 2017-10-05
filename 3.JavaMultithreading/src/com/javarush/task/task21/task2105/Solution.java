package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution n = (Solution) o;
        //return n.first.equals(first) && n.last.equals(last);
        return n.first == first && n.last == last;
    }
    //public int hashCode() {}

    @Override
    public int hashCode() {
        int result = (first == null)? 0: first.hashCode();

        return result*13 + ((last == null) ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
