package com.ryan.stage1.model4.task18;

public class ThreadTest {

    public static void main(String[] args) {

        /**
         * 测试Thread的无参构造方法的所创建的对象调用run()方法是否是啥也没干
         *
         * Thread源码分析
         * 首先new Thread()进入无参构造方法：
         * -> 1. init(null, null, "Thread-" + nextThreadNum(), 0);
         * -> 2. private void init(ThreadGroup g, Runnable target, String name,
         *                       long stackSize) {
         *         init(g, target, name, stackSize, null, true);
         *     }
         * -> 3. 在init方法中因为我们传入的target = null, 又因为在init的方法中this.target = target;所以此时的target == null
         */
        Thread thread = new Thread();

        /**
         * run()方法源码：
         * 4. if (target != null) {
         *             target.run();
         *         }
         * -> 结论：没有执行run()方法
         */
        thread.run();
        System.out.println("测试结果！！");

        /**
         * 测试线程的启动
         */
        //1. 创建一个Thread父类的引用指向子类SubThreadTest的对象
        Thread thread1 = new SubThreadTest();

        //2. run()
        //注意：调用run()方法其实并没有启动一个子线程，只不过是执行SubThreadTest类中的run()，还是又主线程main进行执行指令
        thread1.run();

        //真正启动一条线程，本质是JVM会去启动一条线程，用来执行SubThreadTest类中的run()方法代码
        thread1.start();

        //3. 主线程main方法中打印
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程main打印：" + i);
        }
    }
}
