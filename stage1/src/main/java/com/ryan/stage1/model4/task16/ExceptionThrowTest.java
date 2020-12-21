package com.ryan.stage1.model4.task16;

public class ExceptionThrowTest {

    /**
     * 将异常进行声明抛出
     *
     * @throws InterruptedException
     */
    public static void test() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void main(String[] args) {

        //调用方法要处理异常信息
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
