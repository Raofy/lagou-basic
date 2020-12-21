package com.ryan.stage1.model4.task17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) {

        System.out.println("-------------构造方法-----------------");
        //1. 构造方法一
        FileReader fileReader1 = null;

        try {
            fileReader1 = new FileReader("U:/Ryan/lagou-basic/stage1//src/main/java/com/ryan/stage1/model4/task17/file/myFile.txt");

            System.out.println("----------------常用方法-------------------------");

            /**
             * 1. 读取单个字符的数据并返回，返回-1表示读取到末尾
             */
            int read = fileReader1.read();
            System.out.println((char) read);               // B

            /**
             * 2. 读取全部
             */
            while (fileReader1.read() != -1) {
                int read1 = fileReader1.read();
                System.out.println("字符为：" + (char) read1);
            }

            /**
             * 3. 从输入流中将最多len个字符的数据读入一个字符数组中，返回读取到的字符个数，返回-1表示读取到末尾
             */
            char[] cArr = new char[5];
            fileReader1.read(cArr, 0, 5);
            System.out.println(cArr);                      // Bbcda

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader1 != null) {
                try {
                    /**
                     * 4. 关闭流对象，释放资源
                     */
                    fileReader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
