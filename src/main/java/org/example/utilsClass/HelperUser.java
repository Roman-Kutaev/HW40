package org.example.utilsClass;

import org.example.User.User;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelperUser {
    public static void saveObjectUser(List<User> users) {
        for (User u: users) {
            try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("UserBase.dat"))) {
                output.writeObject(users);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<User> readObjectUser() {
        List<User> users = null;
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream("UserBase.dat"))) {
            users = (List<User>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
