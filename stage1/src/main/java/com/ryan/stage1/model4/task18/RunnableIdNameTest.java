package com.ryan.stage1.model4.task18;

public class RunnableIdNameTest implements Runnable {

    @Override
    public void run() {
        // 获取当前子线程名字
        Thread thread = Thread.currentThread();
        System.out.println("子线程的名字为：" + thread.getName());
        System.out.println("子线程的ID为：" + thread.getId());
    }

    public static void main(String[] args) {

        /**
         * 无参方式创建启动线程
         * 结果打印：
         * 子线程的名字为：Thread-0
         * 子线程的ID为：12
         */
        new Thread(new RunnableIdNameTest()).start();

        /**
         * 设置线程名构造
         * 结果打印
         * 子线程的名字为：fuyi
         * 子线程的ID为：13
         */
        new Thread(new RunnableIdNameTest(),"fuyi").start();

        System.out.println("主线程" + Thread.currentThread().getName());
    }
}
