package org.example.admin;

import java.io.Serializable;
import java.util.Objects;

public class Administrator implements Serializable, Comparable<Administrator> {
    private String login;
    private int password;

    public Administrator(String login, int password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrator)) return false;
        Administrator that = (Administrator) o;
        return password == that.password &&
                login.equals(that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public int compareTo(Administrator o) {
        return ((password - o.password) &
                (login.compareTo(o.login)));
    }
}
