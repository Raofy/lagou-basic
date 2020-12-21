package com.ryan.stage1.model3.task15;

import java.util.LinkedList;
import java.util.List;

public class ListGenericTest {

    public static void main(String[] args) {

        //1. 支持泛型的List
        List<String> list1 = new LinkedList<>();

        //2. 添加元素
        list1.add("fuyi");
        list1.add("1");
        System.out.println(list1);

        //3. 取出集合中的元素
        String s = list1.get(1);
        System.out.println(s);


        System.out.println("-------------Integer类型集合---------");

        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(5);
        System.out.println(list2);
        System.out.println(list2.get(0));


        System.out.println("--------------菱形特性-----------------");
        //JDK7新特性，就是后面<>中的数据类型可以省略
        List<Double> list3 = new LinkedList<>();

        //两种不同泛型的list集合间进行赋值，则编译是会报错误信息的
        //list3 = list1;


        System.out.println("-------------自定义泛型接口类-----------");

        //1. 传入String作为泛型类型
        Student<String> student1 = new Student<>();
        student1.setId(1);
        student1.setName("Tom");
        student1.setGender("boy");
        System.out.println(student1);

        //2. 传入Integer作为泛型类型
        Student<Integer> student2 = new Student<>();
        student2.setGender(1);
        student2.setId(3);
        student2.setName("Lucy");
        System.out.println(student2);


    }
}
