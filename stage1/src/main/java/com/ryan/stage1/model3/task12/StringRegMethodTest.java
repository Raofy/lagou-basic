package com.ryan.stage1.model3.task12;

public class StringRegMethodTest {

    public static void main(String[] args) {

        String str1 = "i am fuyi";
        String[] sArr = str1.split(" ");
        for (String s : sArr) {
            System.out.println(s);
        }


        System.out.println("------------匹配替换----------");

        //将出现的替换字符串全部转换
        String str2 = "i am handsome boy";
        String replace = str2.replace("boy", "girl");
        System.out.println(replace);


        System.out.println("-------------replaceFirst()-------");
        String str3 = "ajdfjaljsldjfljsljfdl";
        String str4 = str3.replaceFirst("j", "4");
        System.out.println(str4);
        String str5 = str3.replaceAll("j", "4");
        System.out.println(str5);
    }
}
