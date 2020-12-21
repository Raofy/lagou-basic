package com.ryan.stage1.model3.task15;

import java.time.Instant;

public class SubStudentTest {

    public static void main(String[] args) {


//        System.out.println("---------不保留泛型且不指定类型---------");
//
//        SubStudent subStudent1 = new SubStudent();
//        subStudent1.setId(1);
//        subStudent1.setName("Sam");
//        subStudent1.setGender("boy");
//        Object gender1 = subStudent1.getGender();
//        System.out.println(subStudent1);
//        System.out.println(gender1);


//        System.out.println("---------不保留泛型且指定了类型---------");
//
//        SubStudent subStudent2 = new SubStudent();
//        subStudent2.setId(2);
//        subStudent2.setName("Lucy");
//        subStudent2.setGender("girl");
//        System.out.println(subStudent2);
//        String gender2 = subStudent2.getGender();
//        System.out.println(gender2);


//        System.out.println("---------保留泛型且由子类决定类型---------");
//
//        SubStudent<Boolean> subStudent3 = new SubStudent();
//        subStudent3.setId(3);
//        subStudent3.setName("KangKang");
//        subStudent3.setGender(true);
//        System.out.println(subStudent3);
//        Boolean gender3 = subStudent3.getGender();
//        System.out.println(gender3);


        System.out.println("---------保留泛型且由子类增加类型---------");

        SubStudent<Boolean, Double> subStudent4 = new SubStudent();
        subStudent4.setId(4);
        subStudent4.setName("John");
        subStudent4.setGender(true);
        System.out.println(subStudent4);
        Boolean gender4 = subStudent4.getGender();
        System.out.println(gender4);


        System.out.println("---------自定义泛型方法---------");

        Integer[] arr = new Integer[] {1, 2, 5, 9, 198};
        Student.genericPrint(arr);

    }
}
