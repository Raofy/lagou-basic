package com.ryan.stage1.model4.task18;

public class SubRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("SubRunnable子线程打印" + i);
        }
    }
}
