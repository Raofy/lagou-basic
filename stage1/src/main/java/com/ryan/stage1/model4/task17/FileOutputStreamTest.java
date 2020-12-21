package com.ryan.stage1.model4.task17;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public static void main(String[] args) {

        System.out.println("-------------------构造方法-----------------------");

        FileOutputStream fileOutputStream1 = null;
        FileOutputStream fileOutputStream2 = null;

        /**
         * 创建文件输出流以写入具有指定名称的文件
         */
        try {
            //1. 构造一 (如果文件不存在会自动创建一个空白文件)
            fileOutputStream1 = new FileOutputStream("e:/myFile.txt");

            //2. 构造二 （进行追加内容）
            fileOutputStream2 = new FileOutputStream("e:/myFile.txt",true);

            System.out.println("--------------------常用方法----------------------");

            /**
             * 1. 将指定字节写入此文件输出流
             */
            fileOutputStream1.write('G');

            /**
             * 2. 将指定字节数组中从偏移量off开始的len个字节写入此文件输出流
             */
            byte[] arr = new byte[] {65, 66, 67, 68};
            fileOutputStream1.write(arr);

            /**
             * 3. 刷新此输出流并强制写出任何缓冲的输出字节
             */
            fileOutputStream1.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileOutputStream1) {
                try {
                    /**
                     * 4. 关闭流对象并释放有关的资源
                     */
                    fileOutputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileOutputStream2) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
