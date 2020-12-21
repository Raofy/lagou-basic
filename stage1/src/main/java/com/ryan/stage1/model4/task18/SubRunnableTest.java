package com.ryan.stage1.model4.task18;

public class SubRunnableTest {

    public static void main(String[] args) {

        SubRunnable subRunnable = new SubRunnable();

        /**
         * 由Thread源码可得target = subRunnable
         */
        Thread thread = new Thread(subRunnable);

        /**
         * if (target != null) {
         *             target.run();
         *         }
         * 而此时的target = subRunnable, 所以调用的是SubRunnable.run()方法
         */
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程main打印" + i);
        }
    }
}
