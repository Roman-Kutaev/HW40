package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Answer implements Serializable {
    private static final long serialVersionUID = 5238986315384529219L;
    String value;
    private boolean answer;

    public Answer(String value, boolean answer) {
        this.value = value;
        this.answer = answer;
    }

    public boolean isAnswer() {
        return answer;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer1 = (Answer) o;
        return value == answer1.value &&
                answer == answer1.answer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, answer);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
