package com.ryan.stage1.model4.task17;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

    public static void main(String[] args) {

        BufferedOutputStream bos = null;

        System.out.println("---------------------构造方法---------------------------");
        try {
            // 1.创建BufferedOutputStream类型的对象与e:/myFile.txt流的框架结构.txt文件关联
            bos = new BufferedOutputStream(new FileOutputStream("e:/myFile.txt"));

            System.out.println("--------------------常用方法----------------------");

            /**
             * 1. 将指定字节写入此文件输出流
             */
            bos.write('G');

            /**
             * 2. 将指定字节数组中从偏移量off开始的len个字节写入此文件输出流
             */
            byte[] arr = new byte[] {65, 66, 67, 68};
            bos.write(arr);

            /**
             * 3. 刷新此输出流并强制写出任何缓冲的输出字节
             */
            bos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流对象并释放有关的资源
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
