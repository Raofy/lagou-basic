package com.ryan.stage1.model4.task16;

public class ExceptionTest {

    public static void main(String[] args) {

        System.out.println("-----------非检测性异常----------");
        /**
         * 此时编译器并没有提示报错，运行时会抛出Exception in thread "main" java.lang.ArithmeticException: / by zero
         */
        System.out.println(4 / 0);

        System.out.println("-----------检测性异常------------");
        /**
         * 会有红色波浪线提示unhandledException，此时需要捕获处理
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
