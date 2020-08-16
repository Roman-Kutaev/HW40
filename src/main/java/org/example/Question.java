package org.example;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Question implements Serializable, Comparable<Question> {
    private static final long serialVersionUID = 9132335283623853162L;
    private String name;
    List<Answer> answers;

    public Question(String name, List<Answer> answers) {
        this.name = name;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return name.equals(question.name) && answers.equals(question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, answers);
    }

    @Override
    public int compareTo(Question o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        int[] counter = {1};
        return  "\n" + name + '?' +
                answers.stream()
                        .map(a -> {
                            String result = "\n" + counter[0] + ") " + a;
                            counter[0]++;
                            return result;
                        })
                .collect(Collectors.joining());

    }

    //    String name;
//    String oneAnswer;
//    String twoAnswer;
//    String threeAnswer;
//    String fourAnswer;
//    String correctAnswer;
//
//    public Question(String name, String oneAnswer, String twoAnswer, String threeAnswer,
//                    String fourAnswer, String correctAnswer) {
//        this.name = name;
//        this.oneAnswer = oneAnswer;
//        this.twoAnswer = twoAnswer;
//        this.threeAnswer = threeAnswer;
//        this.fourAnswer = fourAnswer;
//        this.correctAnswer = correctAnswer;
//    }
//
//    @Override
//    public String toString() {
//        return "\n" + name + "?" + "\n1) " + oneAnswer + "\n2) "
//                + twoAnswer + "\n3) " + threeAnswer + "\n4) " + fourAnswer;
//    }
//
//    @Override
//    public int compareTo(Question o) {
//        return name.compareTo(o.name);
//    }
}
