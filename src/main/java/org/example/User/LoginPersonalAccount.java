package org.example.User;

import org.example.Action;
import org.example.Menu;

import static org.example.utilsClass.HelperUser.readObjectUser;

import java.util.*;

public class LoginPersonalAccount implements Action {
    List<User> users = new ArrayList<>();
    protected static User logUser;

     @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String loginUser = scanner.nextLine();
        System.out.println("Введите пароль");
        int passwordUser = scanner.nextInt();
        logUser = new User(loginUser,passwordUser);
        users = readObjectUser();
        boolean userStatus = false;
        int count = 0;
        for (User u: users) {
            count++;
            if (u.equals(logUser)) {
                userStatus = true;
                Menu menu = new Menu("Добро пожаловать в приложение! ");
                menu.add(new Menu("Просмотр списка тем викторины", new ViewAllTopic()));
                menu.add(new Menu("Прохождение викторины по отдельной теме", new QuizByTopic()));
                menu.add(new Menu("Прохождение викторины по всем темам", new QuizAllTopic()));
                menu.add(new Menu("Изменение личных данных", new ChangeSetting()));
                menu.add(new Menu("Просмотр рейтинга пользователей", new ShowUserList()));
                menu.add(new Menu("Выход из личного кабинета", () -> System.out.println("До свидания") ));

                menu.show();
            }
            if (!userStatus & count == users.size()){
                System.out.println("Данный пользователь не зарегестрирован.");
            }
        }
    }
}