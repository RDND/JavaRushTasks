package com.javarush.task.task26.task2608;

/* Все методы, кроме метода main, класса Solution должны быть thread safe.
Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными тредами.
synchronized(this) для этого не подходит, используй другой объект для лока.
Мудрый человек думает раз, прежде чем два раза сказать
*/
public class Solution {
    volatile int var1;
    volatile int var2;
    volatile int var3;
    volatile int var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        synchronized (this) {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        synchronized (Solution.this) {
            return var3 + var4;
        }
    }

    public static void main(String[] args) {

    }
}
