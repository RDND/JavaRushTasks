package com.javarush.task.task23.task2304;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого — обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого — обновить поле names.
Inner 3
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    private class TaskDataProvider implements DbDataProvider {

        @Override
        public void refreshAllData(Map criteria) {
            tasks = new ArrayList<>();
            tasks = DbMock.getFakeTasks(criteria);
        }
    }
    private class NameDataProvider implements DbDataProvider {

        @Override
        public void refreshAllData(Map criteria) {
            names = new ArrayList<>();
            names = DbMock.getFakeNames(criteria);
        }
    }
    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    public static void main(String[] args) {

    }
}
