package com.ryan.stage1.model3.task12;

import java.util.Scanner;

public class StringRegTest {

    public static void main(String[] args) {


        System.out.println("------正则表达式校验----------");

        //正则表达式只能对数据格式进行验证，无法对数据内容的正确性进行验证
        //描述银行卡密码的规则：由6位数字组成
        String reg = "[0-9]{6}";

        //要求非0开头的5~15为数字组成
        String reg2 = "[1-9]\\d{4,14}";

        //6位代表地区，4位代表年，2位代表月，2位代表日期，3位代表个人，最后一位有可能是X，共18位
        String reg3 = "(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9|X])";

        //2. 提示用户从控制台输入
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入银行卡密码：");
            String next = scanner.next();

            //3. 判断用户输入的银行卡是否满足条件
            if (next.matches(reg)) {
                System.out.println("输入的银行卡密码符合要求");
                break;
            } else {
                System.out.println("输入的银行卡密码不符合要求");
            }
        }
    }
}
