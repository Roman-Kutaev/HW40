package org.example.utilsClass;

import org.example.Question;
import org.example.Topic;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Helper {
    public static void saveObject(Map<Topic, List<Question>> quiz) {
        for (Topic topic : quiz.keySet()) {
            try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("Base.dat"))) {
                output.writeObject(quiz);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<Topic, List<Question>> readObject() {
        Map<Topic, List<Question>> quiz = null;
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream("Base.dat"))) {
            quiz = (Map<Topic, List<Question>>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return quiz;
    }
}
