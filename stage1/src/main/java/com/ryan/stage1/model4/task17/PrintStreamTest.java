package com.ryan.stage1.model4.task17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {

    public static void main(String[] args) {

        System.out.println("---------------构造方法------------------");

        PrintStream printStream1 = null;

        try {
            printStream1 = new PrintStream(new FileOutputStream("e:/myFile.txt"));

            System.out.println("-----------------常用方法-------------------");

            /**
             * 1. 用于将参数指定的字符串内容打印出来
             */
            printStream1.print("fuyinb");

            /**
             * 2. 用于打印字符串后并终止该行
             */
            printStream1.println("cheshigailei");
            printStream1.println("另起一行");

            /**
             * 3. 刷新流
             */
            printStream1.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != printStream1) {
                /**
                 * 4. 关闭流
                 */
                printStream1.close();
            }
        }
    }
}
