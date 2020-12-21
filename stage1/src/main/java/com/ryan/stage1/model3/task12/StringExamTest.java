package com.ryan.stage1.model3.task12;

public class StringExamTest {

    public static void main(String[] args) {


        System.out.println("------------------笔试常考内容------------------");

        //1. 常量池和堆区的内容比较
        String str1 = "abcd";                          //该过程创建一个对象
        String str2 = "abcd";
        String str3 = new String("abcd");      //该过程创建两个对象（1个在常量池中，1个在堆区里面）
        String str4 = new String("abcd");

        System.out.println(str1 == str2);              //true
        System.out.println(str1.equals(str2));         //true
        System.out.println(str3 == str4);              //false
        System.out.println(str3.equals(str4));         //true
        System.out.println(str1 == str3);              //false
        System.out.println(str1.equals(str3));         //true


        System.out.println("----------------------------------------------------");

        //2. 字符串拼接比较
        String str5 = "abcd";
        String str6 = "abc" + "d";

        System.out.println(str5 == str6);              //true
        System.out.println(str5.equals(str6));         //true
        System.out.println(str6 == str3);              //false
        System.out.println(str6.equals(str3));         //true


        System.out.println("----------------------------------------------------");

        //3. 变量与常量拼接比较
        String str7 = "ab";
        String str8 = str7 + "cd";

        System.out.println(str1 == str8);             //false
        System.out.println(str8.equals(str1));        //true
        System.out.println(str8 == str3);             //false
        System.out.println(str8.equals(str3));        //true
    }
}
