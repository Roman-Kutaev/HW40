package org.example.admin;

import org.example.Action;
import org.example.Question;
import org.example.Topic;
import org.example.utilsClass.Helper;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static org.example.utilsClass.Helper.readObject;

public class DeletionTopic implements Action {
    Map<Topic, List<Question>> quiz = new TreeMap<>();

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название темы которую необходимо удалить");
        String nameTopic = scanner.nextLine();
        quiz = readObject();
        boolean topicStatus = false;
        for(Topic topic: quiz.keySet()){
            if (topic.equals(new Topic(nameTopic))){
                topicStatus = true;
            }
        }
        if (topicStatus){
            quiz.remove(new Topic(nameTopic));
            Helper.saveObject(quiz);
            System.out.println("Тема удалена.");
        }else System.out.println("Данной темы нет в базе.");

    }
}