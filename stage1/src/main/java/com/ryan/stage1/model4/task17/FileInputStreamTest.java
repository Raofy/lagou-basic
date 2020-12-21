package com.ryan.stage1.model4.task17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args) {

        System.out.println("-----------------构造方法------------------------");
        FileInputStream fileInputStream1 = null;

        try {
            fileInputStream1= new FileInputStream("e:/myFile.txt");

            System.out.println("----------------常用方法----------------------");

            /**
             * 1. 从输入流中读取单个字节的数据并返回，返回-1表示读取到末尾
             * 注意：这里调用read()方法和迭代器itertor.next()方法是一样，每调用一次，游标向下移动一次
             */
            int read = fileInputStream1.read();
            System.out.println((char) read);

            while ((read = fileInputStream1.read()) != -1) {
                System.out.println((char) read);                              // A B C D
            }

            while (fileInputStream1.read() != -1) {
                System.out.println((char) fileInputStream1.read());           // B D
            }

            /**
             * 2. 从此输入流中将最多 b.length 个字节的数据读入字节数组中，返回读取到的字节个数，返回-1表示读取到末尾
             */
            byte[] brr = new byte[5];
            fileInputStream1.read(brr);
            for (byte b : brr) {
                System.out.print(b);                                         // 71 65 66 67 68
            }

            /**
             * 3. 获取输入流所关联文件的大小
             */
            System.out.println("输入流大小为：" + fileInputStream1.available());// 5
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileInputStream1) {
                try {
                    /**
                     * 4. 关闭流对象并释放有关的资源
                     */
                    fileInputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
