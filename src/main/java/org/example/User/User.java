package org.example.User;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable, Comparable<User> {
    private String name;
    private int password;
    private int dateBirth;
    private int countCorrectAnswers;

    public User(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, int password, int dateBirth, int countCorrectAnswers) {
        this.name = name;
        this.password = password;
        this.dateBirth = dateBirth;
        this.countCorrectAnswers = countCorrectAnswers;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String name, int password, int dateBirth) {
        this.name = name;
        this.password = password;
        this.dateBirth = dateBirth;
    }

    public User(int countCorrectAnswers) {
        this.countCorrectAnswers = countCorrectAnswers;
    }

    public void add(int correctAnswer){
        countCorrectAnswers += correctAnswer;

    }

    public void setDateBirth(int dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getDateBirth() {
        return dateBirth;
    }

    public int getCountCorrectAnswers() {
        return countCorrectAnswers;
    }

    public void setCountCorrectAnswers(int countCorrectAnswers) {
        this.countCorrectAnswers = countCorrectAnswers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name + ", рейтинговых баллов = " + countCorrectAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return password == user.password &&
                name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public int compareTo(User o) {
        return ((password - o.password) &
                (dateBirth - o.dateBirth)&
                (name.compareTo(o.name)));
    }
}