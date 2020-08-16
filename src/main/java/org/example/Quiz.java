package org.example;


import org.example.User.*;
public class Quiz {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Добро пожаловать в приложение! ");
        mainMenu.add(new Menu("Регистрация в викторине", new UserRegistration()));
        mainMenu.add(new Menu("Вход в личный кабинет викторины", new LoginPersonalAccount()));
        mainMenu.add(new Menu("Выход", () -> System.out.println("Всего хорошего")));
        mainMenu.show();

    }
}