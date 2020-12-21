package com.ryan.stage1.model4.task18;

public class AnonymousTest {

    public static void main(String[] args) {

        /**
         * 1. 原始语法
         */
        // 继承Thread类的方式
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("匿名方式创建");
            }
        };
        thread.start();

        // 实现Runnable接口的方式
        Runnable ra = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名方式创建");
            }
        };
        Thread thread1 = new Thread(ra);
        thread1.start();

        /**
         * 2. JDK8的lambda语法
         */
        new Thread(() -> System.out.println("lambda匿名方式创建")).start();

    }
}
