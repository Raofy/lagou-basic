package com.ryan.stage1.model3.task11;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {

        System.out.println("-----------------构造方法--------------------");

        BigDecimal bigDecimal1 = new BigDecimal("1.5");
        BigDecimal bigDecimal2 = new BigDecimal("1.25");


        System.out.println("-----------------常用方法--------------------");

        System.out.println("加法运算：" + bigDecimal1.add(bigDecimal2));        //2.75
        System.out.println("减法运算：" + bigDecimal1.subtract(bigDecimal2));   //0.25
        System.out.println("乘法运算：" + bigDecimal1.multiply(bigDecimal2));   //1.875
        System.out.println("除法运算：" + bigDecimal1.divide(bigDecimal2));     //1.2


        System.out.println("-----------------注意事项---------------------");

        BigDecimal bigDecimal3 = new BigDecimal("1.5");
        BigDecimal bigDecimal4 = new BigDecimal("1.3");
        System.out.println("除不尽小数处理：" + bigDecimal3.divide(bigDecimal4, RoundingMode.HALF_UP)); //1.2

    }
}
