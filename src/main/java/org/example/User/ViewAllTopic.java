package org.example.User;

import org.example.Action;
import org.example.Question;
import org.example.Topic;

import java.util.List;
import java.util.Map;

import static org.example.utilsClass.Helper.readObject;

public class ViewAllTopic implements Action {
    @Override
    public void doAction() {
        Map<Topic, List<Question>> quiz;
        quiz = readObject();
        System.out.println("Полный список тем викторины:");
        for (Topic topic : quiz.keySet()) {
            System.out.println(topic);
        }
    }
}
