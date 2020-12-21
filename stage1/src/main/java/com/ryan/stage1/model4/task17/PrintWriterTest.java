package com.ryan.stage1.model4.task17;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) {

        System.out.println("-------------------构造方法-------------------");

        PrintWriter printWriter1 = null;

        try {
            printWriter1 = new PrintWriter(new FileWriter("e:/myChat.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != printWriter1) {
                printWriter1.close();
            }
        }
    }
}
