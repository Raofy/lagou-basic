package com.ryan.stage1.model4.task16;

public class ExceptionFinallyTest {

    public static int test() {
        try {
            String str = null;
            str.length();
            return 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 1;
        } finally {
            return 2;
        }

    }

    public static void main(String[] args) {

        try {
            int a = 19;
            int b = 1;
            System.out.println("程序开始");
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally语句块");
        }

        int test = test();
        System.out.println("test = " + test);
        System.out.println("程序执行结束");

        //没有发生异常执行流程：         程序开始 -> 19 -> finally语句块 -> 程序执行结束
        //发生异常执行流程：             程序开始 -> java.lang.ArithmeticException: / by zero -> finally语句块 -> 程序执行结束
        //验证finally和return的执行顺序：程序开始 -> 19 -> finally -> java.lang.NullPointerException -> test = 2 -> 程序执行结束
    }
}
