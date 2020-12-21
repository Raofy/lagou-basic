package com.ryan.stage1.model3.task11;

import java.math.BigInteger;

public class BigIntegerTest {

    public static void main(String[] args) {


        System.out.println("-----------------构造方法--------------------");

        BigInteger bigInteger1 = new BigInteger("5");
        BigInteger bigInteger2 = new BigInteger("3");


        System.out.println("-----------------常用方法--------------------");

        System.out.println("加法运算：" + bigInteger1.add(bigInteger2));                        //8
        System.out.println("减法运算：" + bigInteger1.subtract(bigInteger2));                   //2
        System.out.println("乘法运算：" + bigInteger1.multiply(bigInteger2));                   //15
        System.out.println("除法运算：" + bigInteger1.divide(bigInteger2));                     //1

        BigInteger[] bigIntegers = bigInteger1.divideAndRemainder(bigInteger2);
        System.out.println("除法运算一次性获取商和小数：");

        for (BigInteger bigInteger : bigIntegers) {
            System.out.println(bigInteger.floatValue());                                       //1.0 2.0
        }


    }
}
