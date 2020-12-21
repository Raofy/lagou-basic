package com.ryan.stage1.model3.task12;

public class StringCharTest {

    public static void main(String[] args) {

        System.out.println("---------------------String类的常用方法--------------------");

        //1. charAt(int index)方法
        String str1 = "fi387";
        System.out.println("下标为1的元素为：" + str1.charAt(0));        //f
        System.out.println("下标为2的元素为：" + str1.charAt(1));        //i
        System.out.println("下标为3的元素为：" + str1.charAt(2));        //3
        System.out.println("下标为4的元素为：" + str1.charAt(3));        //8
        System.out.println("下标为5的元素为：" + str1.charAt(4));        //7

        //2. isEmpty()判断是否为空
        System.out.println(str1.isEmpty());                            //false

        //3. 笔试考点
        //将字符串"123456"转成整数123456并打印

        //方式一
        String str2 = "123456";
        int i = Integer.parseInt(str2);
        System.out.println(i);

        //方式二
        char[] charArray = str2.toCharArray();
        int sum = 0;
        for (int i1 = 0; i1 < charArray.length; i1++) {
            sum = sum*10 + (charArray[i1] - '0');
        }
        System.out.print(sum);
    }
}
