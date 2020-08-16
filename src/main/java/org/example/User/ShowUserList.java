package org.example.User;

import static org.example.utilsClass.HelperUser.readObjectUser;

import org.example.Action;

import java.util.Comparator;
import java.util.List;


public class ShowUserList implements Action {
    List<User> users;

    @Override
    public void doAction() {
        users = readObjectUser();
        users.sort(Comparator.comparing(User::getCountCorrectAnswers).reversed());
        for (User user : users) {
            System.out.println(user);
            }
        }
    }