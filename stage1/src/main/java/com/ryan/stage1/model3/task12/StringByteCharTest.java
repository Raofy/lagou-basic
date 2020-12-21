package com.ryan.stage1.model3.task12;

public class StringByteCharTest {

    public static void main(String[] args) {


        System.out.println("------------------String、byte数组和char数组间转换-----------------------");


        System.out.println("------------------String -> byte数组-----------------------");

        //1. String -> byte[]
        String str1 = "fuyi";
        byte[] brr = str1.getBytes();
        for (byte b : brr) {
            System.out.println(b);
        }


        System.out.println("------------------String -> char数组-----------------------");

        //2. String -> char[]
        char[] crr = str1.toCharArray();
        for (char c : crr) {
            System.out.println(c);
        }


    }
}
