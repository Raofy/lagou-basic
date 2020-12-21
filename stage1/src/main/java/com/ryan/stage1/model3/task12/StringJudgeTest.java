package com.ryan.stage1.model3.task12;

public class StringJudgeTest {

    public static void main(String[] args) {

        System.out.println("------------String回文判断--------------");

        String str1 = "上海自来水来自海上";
        for (int i = 0; i < str1.length()/2; i++) {
            if (str1.charAt(i) != str1.charAt(str1.length()-1-i)) {
                System.out.println("字符串" + str1 + "不是回文");
                return;
            }
        }
        System.out.println("字符串" + str1 + "是回文");
    }
}
