package com.ryan.stage1.model4.task17;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;

    private String sid;

    public Student(String name, String sid) {
        this.name = name;
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}
