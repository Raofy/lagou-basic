package com.ryan.stage1.model4.task18;

public class SubThreadTest extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("SubThreadTeat子线程打印" + i);
        }
    }
}
