package org.example;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Topic implements Serializable, Comparable<Topic> {
    private String name;
    private List<Question> list;



    public Topic(String name, List<Question> list) {
        this.name = name;
        this.list = list;
    }

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getList() {
        return list;
    }

    public void setList(List<Question> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;
        Topic topic = (Topic) o;
        return name.equals(topic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Topic o) {
        return name.compareTo(o.name);
    }
}
