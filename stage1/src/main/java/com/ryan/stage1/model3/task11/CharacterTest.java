package com.ryan.stage1.model3.task11;

public class CharacterTest {

    public static void main(String[] args) {


        System.out.println("----------------Character类的自动装箱和自动拆箱----------------");

        //1. JDK5之前
        //装箱
        Character character1 = Character.valueOf('b');
        System.out.println(character1);                                      //b

        //拆箱
        char b = character1.charValue();
        System.out.println(b);                                               //b

        //2. JDK5之后的自动拆装箱
        Character character2 = 'c';
        char c = character2;


        System.out.println("----------------Character类的常用方法----------------");

        System.out.println("是否大写：" + Character.isUpperCase(c));          //false
        System.out.println("是否小写：" + Character.isLowerCase(c));          //true
        System.out.println("转成大写：" + Character.toUpperCase(c));          //C
        System.out.println("转成小写：" + Character.toLowerCase(c));          //c
     }
}
