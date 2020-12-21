package com.ryan.stage1.model3.task11;

public class MathTest {

    public static void main(String[] args) {

        System.out.println("-----------------------Math类常用方法------------------------");

        System.out.println("比较最大：" + Math.max(10, 20));                    //20
        System.out.println("比较最小：" + Math.min(10, 20));                    //10
        System.out.println("返回第一个自变量的幂运算：" + Math.pow(3.4, 4.5));    //246.4081832376189
        System.out.println("绝对值：" + Math.abs(-5));                          //5
        System.out.println("四舍五入：" + Math.round(4.3));                     //4
        System.out.println("随机生成0~1的小数：" + Math.random());               //0.7426799959126971
        System.out.println("平方根：" + Math.sqrt(9));                          //3.0
    }
}
