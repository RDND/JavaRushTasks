package com.javarush.task.task30.task3012;

/* Реализуй метод createExpression(int number).
Метод createExpression вызывается с одним параметром number. Этот параметр — число от 1 до 3000 включительно.
Нужно вывести арифметическое выражение, результатом которого является число number.
Можно использовать числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.
Можно использовать знаки: «+» и «—» любое количество раз.
Обрати внимание, что перед каждым числом в искомой строке обязательно должен быть знак плюс или минус.
Перед выражением выведи [переданное число] =. (Смотри примеры вывода ниже).
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(24);
    }

    public void createExpression(int number) {

        int[] array = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder result = new StringBuilder(number + " =");
        StringBuffer znaks = new StringBuffer();
        while (true) {
            int ost = number % 3;
            number /= 3;
            if (ost == 0)
                znaks.append("0");
            else if (ost == 1)
                znaks.append("+");
            else {
                number++;
                znaks.append("-");
            }
            if (number == 1) {
                znaks.append("+");
                break;
            }
        }
        int len = znaks.length();
        for (int i = 0; i < len; i++) {
            char zn = znaks.charAt(i);
            if (zn != '0')
                result.append(" " + zn + " " + array[i]);
        }
        System.out.println(znaks);
        //System.out.println(result);
    }
}