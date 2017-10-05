package com.javarush.task.task30.task3004;




import java.util.concurrent.RecursiveTask;

/**2. Реализуй логику метода compute — число должно переводиться в двоичное представление.
 3. Используй методы fork и join.
 4. Пример функциональной реализации — метод binaryRepresentationMethod.
 * Created by RDND on 12.07.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;
    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return result;
    }
}
