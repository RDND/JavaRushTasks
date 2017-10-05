package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        //Model model = new FakeModel();
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        usersView.fireEventShowAllUsers();
//https://github.com/donRumata83/JavaRushTasks/tree/master/3.JavaMultithreading/src/com/javarush/task
        EditUserView editUserView = new EditUserView();
        editUserView.setController(controller);
        controller.setEditUserView(editUserView);
        usersView.fireEventOpenUserEditForm(126);
//необходимо вызвать метод открытия формы редактирования для пользователя с id=126
// у объекта класса UsersView перед вызовом метода fireEventShowDeletedUsers().
        editUserView.fireEventUserChanged("X", 126, 1);

        editUserView.fireEventUserDeleted(124L);

        usersView.fireEventShowDeletedUsers();
    }
}