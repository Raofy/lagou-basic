package com.ryan.stage1.model3.task11;

public class DoubleTest {

    public static void main(String[] args) {


        System.out.println("---------------------常用方法------------------------");

        //1. 判断是否为非数值
        Double double1 = new Double(187.293847);
        double v = Double.parseDouble("18.983");
        System.out.println("是否为非数值：" + double1.isNaN());               //是否为非数值：false
        System.out.println("是否为非数值：" + Double.isNaN(v));               //是否为非数值：false
    }
}
