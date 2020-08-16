package org.example.User;

import org.example.Action;
import org.example.Answer;
import org.example.Question;
import org.example.Topic;
import org.example.utilsClass.HelperUser;

import java.util.*;

import static org.example.utilsClass.Helper.readObject;
import static org.example.utilsClass.HelperUser.readObjectUser;

public class QuizByTopic implements Action {
    @Override
    public void doAction() {
        Map<Topic, List<Question>> quiz;
        quiz = readObject();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название викторины которую хотите пройти");
        String nameTopic = scanner.nextLine();
        for (Topic topic : quiz.keySet()) {
            if (topic.equals(new Topic(nameTopic))) {
                int greatAnswers = 0;
                int numberQuestions = 0;
                for (int i = 0; i < 10; i++) {
                    Question question = quiz.get(topic).get(i);
                    System.out.println(question);
                    numberQuestions += 1;
                    System.out.println("Выберете правильный вариант ответа");
                    int answerFromUser = scanner.nextInt();

                    List<Answer> answers = question.getAnswers();

                    int[] index = {0};
                    Answer correctAnswer = answers.stream()
                            .peek(a -> index[0]++)
                            .filter(Answer::isAnswer)
                            .findFirst()
                            .orElse(null);

                    boolean isUserAnswerCorrect = answerFromUser == index[0];
                    if (isUserAnswerCorrect) {
                        greatAnswers++;
                        System.out.println("Вы ответили верно.");
                    } else System.out.println("Вы ответили не верно.");

                    if (numberQuestions == 10) {
                        System.out.println("Викторина окончена.\nУ вас " + greatAnswers + " правильных ответов!\n");
                        List<User> users;
                        users = readObjectUser();
                        for (User user : users) {
                            if (user.equals(LoginPersonalAccount.logUser))
                            user.add(greatAnswers);

                        }
                        HelperUser.saveObjectUser(users);
                        return;
                    }
                }
            }
        }

    }
}