package com.ryan.stage1.model4.task17;

import java.io.*;

public class OutputStreamWriterTest {

    public static void main(String[] args) {
        OutputStreamWriter outputStreamWriter1 = null;
        OutputStreamWriter outputStreamWriter2 = null;

        try {

            //构造方法一
            outputStreamWriter1 = new OutputStreamWriter(new FileOutputStream("e:/myFile.txt"));

            //构造方法二
            outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream("e:/myFile.txt"), "utf-8");

            System.out.println("------------------常用方法-------------------");

            /**
             * 1. 将参数指定的字符串写入
             */
            outputStreamWriter1.write(68);
            outputStreamWriter1.write("jshgh");
            outputStreamWriter1.write('j');

            /**
             * 2. 刷新流
             */
            outputStreamWriter1.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStreamWriter1) {
                try {
                    /**
                     * 3. 关闭流
                     */
                    outputStreamWriter1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStreamWriter2) {
                try {
                    outputStreamWriter2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
