package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/
public class Solution {
    //static
    private String name;

    Solution(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

     private void sout() {
        new Solution("sout") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {

        new Solution("main").sout();
    }
}
