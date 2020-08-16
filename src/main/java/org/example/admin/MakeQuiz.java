package org.example.admin;

import org.example.Menu;

import java.util.*;

import static org.example.utilsClass.HelperAdmin.readObjectAdmin;

public class MakeQuiz {
    public static void main(String[] args) {
        List<Administrator> administrators;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин администратора");    // admin
        String loginAdmin = scanner.nextLine();
        System.out.println("Введите пароль администратора");   // 123321
        int passwordAdmin = scanner.nextInt();
        administrators = readObjectAdmin();
        boolean addStatus = false;
        for (Administrator a : administrators) {
            if (a.equals(new Administrator(loginAdmin, passwordAdmin))) {
                addStatus = true;
                Menu menu = new Menu("\nВы находитесь в сервисном меню викторины:");
                menu.add(new Menu("Создание новой темы и вопросов к ней", new AddTopic()));
                menu.add(new Menu("Удаление темы и вопросов к ней", new DeletionTopic()));
                menu.add(new Menu("Полная распечатка всех тем викторины", new ShowAllTopic()));
                menu.add(new Menu("Добавление нового администратора", new AddAdmin()));
                menu.add(new Menu("Выход", () -> System.out.println("Всего хорошего")));

                menu.show();
            }
            if (!addStatus){
                System.out.println("Отказанно в доступе.");

            }
        }
    }
}