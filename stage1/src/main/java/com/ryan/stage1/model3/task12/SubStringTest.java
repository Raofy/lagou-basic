package com.ryan.stage1.model3.task12;

public class SubStringTest {


    public static void main(String[] args) {

        String str1 = "Happy Life";

        //1. 从下标为3开始截取字符串
        String substring = str1.substring(3);
        System.out.println(substring);

        //2. 截取指定范围内的子字符串
        String substring1 = str1.substring(3, 5);
        System.out.println(substring1);
    }
}
