package com.ryan.stage1.model3.task11;

public class BooleanTest {

    public static void main(String[] args) {


        System.out.println("----------------Boolean类的自动装箱和自动拆箱----------------");
        //1. JDK5之前
        //装箱
        Boolean boolean1 = Boolean.valueOf("true");
        System.out.println(boolean1);                           //true
        //拆箱
        boolean b = boolean1.booleanValue();
        System.out.println(b);                                  //true

        //2. JDK5之后
        //自动装箱和自动拆箱
        Boolean boolean2 = false;
        boolean b2 = boolean2;
        System.out.println(b2);                                 //false

    }
}
