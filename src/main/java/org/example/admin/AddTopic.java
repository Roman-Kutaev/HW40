package org.example.admin;

import org.example.Action;
import org.example.Answer;
import org.example.Question;
import org.example.Topic;
import org.example.utilsClass.Helper;

import static org.example.utilsClass.Helper.readObject;

import java.util.*;

public class AddTopic implements Action {
    Map<Topic, List<Question>> quiz;

    @Override
    public void doAction() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Введите название новой темы");
        String nameTopic = scanner.nextLine();
        quiz = readObject();
        quiz.put(new Topic(nameTopic), new ArrayList<>());
        int count = 0;
        while (count < 10) {
            System.out.println("Введите " + (count + 1) + " вопрос");
            String questionName = scanner3.nextLine();

            System.out.println("Введите " + (1) + " вариант ответа");
            String oneAnswer = scanner.nextLine();
            System.out.println("Введите правильность ответа");
            boolean oneAnswerCorrect = scanner1.nextBoolean();
            System.out.println("Введите " + (2) + " вариант ответа");
            String twoAnswer = scanner.nextLine();
            System.out.println("Введите правильность ответа");
            boolean twoAnswerCorrect = scanner1.nextBoolean();
            System.out.println("Введите " + (3) + " вариант ответа");
            String threeAnswer = scanner.nextLine();
            System.out.println("Введите правильность ответа");
            boolean threeAnswerCorrect = scanner1.nextBoolean();
            System.out.println("Введите " + (4) + " вариант ответа");
            String fourAnswer = scanner.nextLine();
            System.out.println("Введите правильность ответа");
            boolean fourAnswerCorrect = scanner1.nextBoolean();

            List<Answer> answers = Arrays.asList(
                    new Answer(oneAnswer, oneAnswerCorrect),
                    new Answer(twoAnswer,twoAnswerCorrect),
                    new Answer(threeAnswer,threeAnswerCorrect),
                    new Answer(fourAnswer,fourAnswerCorrect)
            );

            quiz.get(new Topic(nameTopic)).add(new Question(questionName, answers));
            count += 1;
        }
        Helper.saveObject(quiz);
        System.out.println("Новая тема успешно добавлена.");
    }
}