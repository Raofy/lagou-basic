package com.ryan.stage1.model4.task16;

public class StudentTest {

    public static void main(String[] args) {

        /**
         * 1. 当使用throw的方式进行将一场进行跑出去的时候，由调用者进行try-catch进行捕获进行处理的时候，一旦发生异常就不会生成对象
         *
         * 打印结果：
         *
         * student1 = Student{name='fuyi', age=10}
         * com.ryan.stage1.model4.task16.AgeException: 年龄不合理
         * 	at com.ryan.stage1.model4.task16.Student.setAge(Student.java:32)
         * 	at com.ryan.stage1.model4.task16.Student.<init>(Student.java:39)
         * 	at com.ryan.stage1.model4.task16.StudentTest.main(StudentTest.java:13)
         */
        try {
            Student student1 = new Student("fuyi", 10);
            System.out.println("student1 = " + student1);
            Student student2 = new Student("Sam", 130);
            System.out.println("student2  =" + student2);
        } catch (AgeException e) {
            e.printStackTrace();
        }

        /**
         * 2. 如果在方法本身内部使用try-catch进行捕获处理，对象还是会生成
         *
         * 打印结果：
         * com.ryan.stage1.model4.task16.AgeException: 年龄不合理
         * 	at com.ryan.stage1.model4.task16.Student.setAge(Student.java:32)
         * 	at com.ryan.stage1.model4.task16.Student.<init>(Student.java:45)
         * 	at com.ryan.stage1.model4.task16.StudentTest.main(StudentTest.java:22)
         * student3 = Student{name='Lucy', age=0}
         */
//        Student student3 = new Student("Lucy", 123);
//        System.out.println("student3 = " + student3);
    }
}
