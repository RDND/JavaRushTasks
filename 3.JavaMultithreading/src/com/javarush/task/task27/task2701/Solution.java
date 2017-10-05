package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
        reader.close();

    }


    static boolean isSubstringPresent(String substring, String string) {

        boolean found = false;
        int max = string.length() - substring.length();
        int i = 0;
        int length = substring.length();
        while (i <= max && !found) {
            while ((string.charAt(i) != substring.charAt(0)) && (i <= max)) i++;
            if (i <= max) {
                int k = 1;
                boolean br = false;
                while (k < length && !br)
                    if (string.charAt(i + k) != substring.charAt(k++))
                        br = true;
                if (!br)
                    found = true;
                else i++;
            }
        }
        return found;
    }
}

