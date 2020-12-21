package com.ryan.stage1.model4.task17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

    public static void main(String[] args) {
        System.out.println("--------------构造方法------------------");

        BufferedReader bufferedReader1 = null;

        try {
            bufferedReader1 = new BufferedReader(new FileReader("e:/myFile.txt"));

            System.out.println("-----------------常用方法---------------");

            /**
             * 1. 从输入流读取单个字符，读取到末尾则返回-1，否则返回实际读取到的字符内容
             */
            int read = bufferedReader1.read();
            System.out.println((char) read);

            /**
             * 2. 从输入流中读满整个数组cbuf
             */
            char[] crr = new char[5];
            bufferedReader1.read(crr);
            System.out.println(crr);

            /**
             * 3. 读取一行字符串并返回，返回null表示读取到末尾
             */
            String str = null;
            while ((str = bufferedReader1.readLine()) != null) {
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedReader1) {
                try {
                    /**
                     * 4. 关闭资源
                     */
                    bufferedReader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
