package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* Используя StringTokenizer разделить query на части по разделителю delimiter.
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] s = new String[tokenizer.countTokens()];
        int i = 0;
        while(tokenizer.hasMoreTokens())
            s[i++] = tokenizer.nextToken();
        return s;
    }
}
