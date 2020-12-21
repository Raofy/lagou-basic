package com.ryan.stage1.model3.task12;

public class StringIndexTest {

    public static void main(String[] args) {

        String str1 = "Good Good study, Day Day up!";
        String str3 = str1 + "bn";

        int g = str1.indexOf('g');
        System.out.println(g);

        int g1 = str1.indexOf("G");
        System.out.println(g1);

        int g2 = str1.indexOf('G', 1);
        System.out.println(g2);

        //2. 查找字符串
        int day = str1.indexOf("Day");
        System.out.println(day);              //第一次出现的位置


        System.out.println("----------通过上述字符串中出现指定字符串的所有位置--------");

        int pos = 0;
        while ((pos = str1.indexOf("Day", pos)) != -1) {
            System.out.println("pos = " + pos);
            pos += "Day".length();
        }


        System.out.println("-----实现字符串的反向查找-----------");

        int g3 = str1.lastIndexOf('G');
        System.out.println(g3);

        int g4 = str1.lastIndexOf('G', 5);
        System.out.println(g4);

        int day1 = str1.lastIndexOf("Day");
        System.out.println(day1);

        int day2 = str1.lastIndexOf("Day", 5);
        System.out.println(day2);

    }
}
