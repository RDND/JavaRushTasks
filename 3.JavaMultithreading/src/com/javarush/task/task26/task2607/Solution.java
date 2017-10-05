package com.javarush.task.task26.task2607;

/* 
Вежливость - это искусственно созданное хорошее настроение
*/
public class Solution {
    static public class IntegerHolder{
        volatile private int value;
        synchronized public int get() {
            return value;
        }
        synchronized public void set(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
    }
}
