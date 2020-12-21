package com.ryan.stage1.model4.task18;

public class ThreadIdNameTest extends Thread{

    public ThreadIdNameTest(String name) {
        super(name);
    }

    public ThreadIdNameTest() {

    }

    /**
     * 测试对线程id和name的管理
     */
    @Override
    public void run() {
        System.out.println("子线程的信息：");
        System.out.println("子线程的名字：" + getName());
        System.out.println("子线程的Id：" + getId());
    }

    public static void main(String[] args) {

        /**
         * 结果打印
         * 子线程的名字：Thread-0
         * 子线程的Id：12
         */
        Thread thread = new ThreadIdNameTest();
        thread.start();

        /**
         * 修改线程名 fuyi
         * 子线程的名字：fuyi
         * 子线程的Id：13
         */
        ThreadIdNameTest thread2 = new ThreadIdNameTest("fuyi");
        thread2.start();

        /**
         * 获取当前主线程
         * 主线程名字为：main
         * 主线程ID为：1
         */
        Thread thread1 = Thread.currentThread();
        System.out.println("主线程名字为：" + thread1.getName());
        System.out.println("主线程ID为：" + thread1.getId());
    }
}
