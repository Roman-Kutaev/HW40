package org.example.User;

import org.example.User.LoginPersonalAccount.*;
import org.example.Action;
import org.example.utilsClass.HelperUser;

import static org.example.utilsClass.HelperUser.readObjectUser;

import java.util.*;

public class ChangeSetting implements Action {
    @Override
    public void doAction() {
        List<User> users;
        Scanner scanner = new Scanner(System.in);
        users = readObjectUser();
        for (User user : users) {
            if (user.equals(LoginPersonalAccount.logUser)) {
                System.out.println("Введите новый пароль");
                int newPassword = scanner.nextInt();
                user.setPassword(newPassword);
                System.out.println("Введите новую дату рождения");
                int newDateBirth = scanner.nextInt();
                user.setDateBirth(newDateBirth);
                System.out.println("Данные изменены успешно.");
                HelperUser.saveObjectUser(users);
            }
        }
    }
}