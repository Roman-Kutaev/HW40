package org.example.admin;

import org.example.Action;
import org.example.utilsClass.HelperAdmin;

import static org.example.utilsClass.HelperAdmin.readObjectAdmin;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class AddAdmin implements Serializable, Action {
    List<Administrator> administrators;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин нового администратора");
        String loginAdmin = scanner.nextLine();
        System.out.println("Введите пароль нового администратора");
        int passwordAdmin = scanner.nextInt();
        administrators = readObjectAdmin();
        administrators.add(new Administrator(loginAdmin,passwordAdmin));
        HelperAdmin.saveObjectAdmin(administrators);
        System.out.println("Новый администратор добавлен.");
    }
}
