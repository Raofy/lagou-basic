package com.ryan.stage1.model4.task16;

public class Student {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    /**
     * 使用throw进行声明异常
     *
     * @param age
     * @throws AgeException
     */
    public void setAge(int age) throws AgeException {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            throw new AgeException("年龄不合理");
        }

    }

    public Student(String name, int age) throws AgeException {
        setName(name);
        setAge(age);
    }

//    public Student(String name, int age) {
//        setName(name);
//        try {
//            setAge(age);
//        } catch (AgeException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
