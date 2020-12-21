package com.ryan.stage1.model3.task12;

public class StringMethodTest {

    public static void main(String[] args) {

        String str1 = "  let me see see!";

        //1. contains(String str)方法
        System.out.println(str1.contains("see"));      //true

        //2. 大小写转换
        String str2 = str1.toUpperCase();
        System.out.println(str2);                      //  LET ME SEE SEE!
        System.out.println(str1);                      //  let me see see!

        //3. 去除首尾空白段

    }
}
