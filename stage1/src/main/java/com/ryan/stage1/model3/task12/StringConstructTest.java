package com.ryan.stage1.model3.task12;


public class StringConstructTest {

    public static void main(String[] args) {

        System.out.println("----------------常用构造方法------------------");

        //1. 无参构造方法
        //结果：创建了对象，但是对象里面没有内容
        String str1 = new String();
        System.out.println("无参构造打印：" + str1);       //""

        //2. 通过字节数组构造
        byte[] arr = {97, 98, 99, 100, 101};             //abcde
        String str2 = new String(arr);
        System.out.println("字节数组构造：" + str2);       //abcde

        String str3 = new String(arr, 2, 2);//cd
        System.out.println("字节数组构造：" + str3);

        //3. 通过字符数组构造
        char[] brr = {'a', 'b', 'c', 'd', 'e'};
        String str4 = new String(brr);
        System.out.println("字符数组构造：" + str2);       //abcde

        String str5 = new String(brr, 2, 3);
        System.out.println("字符数组构造：" + str5);       //cde

        //4. 字符串构造方法
        String str6 = new String("hello world");
        System.out.println("字符串数组构造：" + str6);      //hello world
    }
}
