package com.ryan.stage1.model4.homework1;

import java.io.Serializable;

public class Student implements Serializable {

    private String sid;

    private String name;

    private int age;

    public Student(String sid, String name, int age) {
        setSid(sid);
        setName(name);
        setAge(age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        if (null != sid) {
            this.sid = sid;
        } else {
            try {
                throw new SidException("学号不能为空！！");
            } catch (SidException e) {
                e.printStackTrace();
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            try {
                throw new AgeException("年龄不合理！！");
            } catch (AgeException e) {
                e.printStackTrace();
            }
        }
    }
}
