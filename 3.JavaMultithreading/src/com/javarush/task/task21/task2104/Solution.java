package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) return true;

        if ((o == null)
                //|| (this.getClass() != o.getClass())
                ) return false;
        if (!(o instanceof Solution)) return false;
        Solution s1 = (Solution) o;
        return (s1.first == this.first) && (s1.last == this.last);
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;

        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args)  {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
