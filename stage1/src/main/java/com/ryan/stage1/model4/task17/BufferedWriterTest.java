package com.ryan.stage1.model4.task17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

    public static void main(String[] args) {

        System.out.println("-----------构造方法--------------");

        BufferedWriter bufferedWriter1 = null;

        try {
            bufferedWriter1 = new BufferedWriter(new FileWriter("e:/myFile.txt"));

            System.out.println("-------常用方法--------------");

            /**
             * 1. 写入单个字符到输出流中
             */
            bufferedWriter1.write(70);

            /**
             * 2. 将字符串数组cbuf中所有内容写入输出流中
             */
            char[] cArr = new char[] {'b', 'n', 'y'};
            bufferedWriter1.write(cArr);

            /**
             * 3. 将参数指定的字符串内容写入输出流中
             */
            bufferedWriter1.write("fuyi");

            /**
             * 4. 用于写入行分隔符到输出流中
             */
            bufferedWriter1.newLine();

            bufferedWriter1.write(cArr);

            /**
             * 5. 刷新流
             */
            bufferedWriter1.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedWriter1) {
                try {
                    /**
                     * 6. 关闭资源
                     */
                    bufferedWriter1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
