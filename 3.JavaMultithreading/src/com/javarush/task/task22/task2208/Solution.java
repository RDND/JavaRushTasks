package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}

Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kyiv");
        map.put("age", null);
        for (Map.Entry<String, String> pair: map.entrySet())
            System.out.println(pair.getKey() + " " + pair.getValue());
        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder str = new StringBuilder();
        for (Map.Entry entry : params.entrySet()) {
            if (entry.getValue() != null) {
                if (str.toString().equals(""))
                    str.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                else
                    str.append(" and ").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            }

        }
        return str.toString();
    }
}
