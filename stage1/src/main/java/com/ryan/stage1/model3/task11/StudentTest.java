package com.ryan.stage1.model3.task11;

public class StudentTest {

    public static void main(String[] args) {
        //创建两个student对象
        Student student1 = new Student("fuyi", 1000);
        Student student2 = new Student("fuyi", 1000);
        Student student3 = student1;


        System.out.println("-------------------------equals()--------------------------");

        //1. 调用Object类中equals方法
        //2. 通过下面两种方式进行测试Object类的equals方法，用来比较的是两个对象的引用是否相等
        //3. Object类源码层次
        /**
         * public boolean equals(Object obj) {
         *         return (this == obj);
         *     }
         */
        //4. 如果通过equals方法比较两个对象的id是否相等，则需要重写Object基类的equals方法
        System.out.println(student1.equals(student2));       //false -> true
        System.out.println(student1 == student2);            //false
        System.out.println(student3 == student1);            //true


        System.out.println("------------------------hashCode()--------------------------");


        //1. 调用Object类中的hashCode()方法
        //2. Java官方常规约束，调用equals（）方法比较的结果的相同，那么调用hashCode（）获取两个对象的结果也应该相同，所以我们需要重写基类中的hashCode()方法
        //3. 这里只要求约束为equals比较结果相等的两个对象，调用hashCode方法结果也相等就可以了
        System.out.println(student1.hashCode());            //1300109446  ->  1000
        System.out.println(student2.hashCode());            //1020371697  ->  1000


        System.out.println("------------------------toString()---------------------------");

        //1. 调用Object类中的toString()方法
        //2. 为了返回更有意义的字符串信息需要重写toString()方法
        //3. 直接打印对象和字符串拼接，默认调用toString方法
        System.out.println(student1.toString());           //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
        System.out.println(student2.toString());           //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
        System.out.println(student1);                      //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
        System.out.println(student2);                      //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
        System.out.println("打印结果：" + student1);        //打印结果：com.ryan.stage1.model3.task11.Student@3e8  ->  打印结果：Student{name='fuyi', id=1000}
        System.out.println("打印结果：" + student2);        //打印结果：com.ryan.stage1.model3.task11.Student@3e8  ->  打印结果：Student{name='fuyi', id=1000}


        System.out.println("------------------------getClass()----------------------------");

        //1. 获取该对象的实例，常用于反射机制
        System.out.println(student1.getClass());           //class com.ryan.stage1.model3.task11.Student
        System.out.println(student2.getClass());           //class com.ryan.stage1.model3.task11.Student


    }
}
