package com.ryan.stage1.model3.task15;

public class Student<T> {

    private String name;

    private int id;

    private T gender;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender=" + gender +
                '}';
    }

    public Student() {
    }

    public Student(String name, int id, T gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getGender() {
        return gender;
    }

    public void setGender(T gender) {
        this.gender = gender;
    }

    //自定义泛型方法
    public static <T> void genericPrint(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
        }
    }
}
