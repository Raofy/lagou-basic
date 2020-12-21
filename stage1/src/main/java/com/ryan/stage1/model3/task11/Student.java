package com.ryan.stage1.model3.task11;

import java.util.Objects;

public class Student {


    private String name;

    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
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


//    @Override
//    public boolean equals(Object obj) {
//        //当如果两个对象指向同一个地址引用的时候，一定为true
//        if (this == obj) {
//            return true;
//        }
//
//        //当传入的对象为null时候，一定是为false
//        if (obj == null) {
//            return false;
//        }
//
//        //重写equals方法用来实现两个对象ID的比较
//        if (obj instanceof Student) {
//            Student flag = (Student) obj;
//            return this.id == flag.getId();
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return getId();
//    }
//
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
