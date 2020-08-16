package org.example.utilsClass;

import org.example.admin.Administrator;
import java.io.*;
import java.util.List;

public class HelperAdmin {
    public static void saveObjectAdmin(List<Administrator> administrators) {
        for (Administrator a: administrators) {
            try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("AdminBase.dat"))) {
                output.writeObject(administrators);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Administrator> readObjectAdmin() {
        List<Administrator> administrators = null;
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream("AdminBase.dat"))) {
            administrators = (List<Administrator>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return administrators;
    }
}