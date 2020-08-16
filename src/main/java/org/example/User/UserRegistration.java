package org.example.User;

import static org.example.utilsClass.HelperUser.readObjectUser;
import org.example.Action;
import org.example.utilsClass.HelperUser;

import java.util.*;

public class UserRegistration implements Action {
    List<User> users = new ArrayList<>();
    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя");
        String name = scanner.nextLine();
        System.out.println("Введите пароль");
        int password = scanner.nextInt();
        System.out.println("Введите свою дату рождения");
        int dateBirth = scanner.nextInt();
        users = readObjectUser();
        for (User user: users){
            if (user.equals(new User(name))){
                System.out.println("Данный логин уже существует.");
                return;
            }
        }
        users.add(new User(name,password,dateBirth));
        System.out.println("Поздравляем, регистрация прошла успешно!");
        HelperUser.saveObjectUser(users);
    }
}