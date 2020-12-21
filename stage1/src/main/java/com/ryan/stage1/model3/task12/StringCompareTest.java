package com.ryan.stage1.model3.task12;

public class StringCompareTest {

    public static void main(String[] args) {

        String str1 = "hello";

        System.out.println(str1.compareTo("hetto"));               // 76-84 = -8
        System.out.println(str1.compareTo("gto"));                 // 72-71 = 1
        System.out.println(str1.compareToIgnoreCase("HELLO")); //0
    }
}
