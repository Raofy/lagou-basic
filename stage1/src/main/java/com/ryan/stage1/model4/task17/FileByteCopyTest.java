package com.ryan.stage1.model4.task17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteCopyTest {

    public static void main(String[] args) {

        //测试拷贝效率
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            //1. 创建文件输入流
            fileInputStream = new FileInputStream("e:/myFile.txt");

            //2. 创建文件输出流
            fileOutputStream = new FileOutputStream("e:/myFileCopys.txt");

            //3. 读取一个字节然后写入一个字节
            int read = 0;
            while ((read = fileInputStream.read()) != -1) {
                fileOutputStream.write(read);
            }

            //4. 使用缓存分多少次进行读写
            byte[] brr = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(brr)) != -1) {
                fileOutputStream.write(brr, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (null != fileInputStream)  {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileOutputStream)  {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Copy消耗时间" + (end - start) + "ms");          //9ms
        System.out.println("缓存方式Copy消耗时间" + (end - start) + "ms");   //1ms
    }
}
