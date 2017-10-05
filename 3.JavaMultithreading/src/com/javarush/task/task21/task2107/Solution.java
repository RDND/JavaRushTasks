package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.
Глубокое клонирование карты
*/
public class Solution implements Cloneable{
    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for (Map.Entry<String, User> pair: users.entrySet()) {
            solution.users.put(pair.getKey(), pair.getValue());
        }
        return solution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User(age, name);
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
