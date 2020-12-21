package com.ryan.stage1.model4.task17;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    public static void main(String[] args) {

        FileWriter fileWriter1 = null;
        FileWriter fileWriter2 = null;
        try {
            //1. 构造方法一（如果文件不存在会自动创建一个空白文件；如果文件存在，流会自动清空文件中的原有内容）
            fileWriter1 = new FileWriter("U:/Ryan/lagou-basic/stage1//src/main/java/com/ryan/stage1/model4/task17/file/myFile.txt");

            System.out.println("--------------------------FileWriter类常用方法--------------------------------------");

            /**
             *  1. 写入单个字符，
             */
            fileWriter1.write("B");                      // B

            /**
             * 2. 将指定字符数组中从偏移量off开始的len个字符写入此文件输出流
             */
            char[] cArr = new char[]{'a', 'b', 'c', 'd'};
            fileWriter1.write(cArr, 1, 3);        // bcd

            /**
             * 3. 将cbuf.length个字符从指定字符数组写入此文件输出流中
             */
            fileWriter1.write(cArr);                      // bcdabcd

            /**
             * 4. 刷新流
             */
            fileWriter1.flush();

            System.out.println("--------------------------内容追加的方式进行创建FileWriter对象---------------------------------");
            //2. 构造方法二(如果文件不存在会自动创建一个空白文件；如果文件存在，流会自动保存原有那日容，并以追加方式添加内容)
            fileWriter2 = new FileWriter("U:/Ryan/lagou-basic/stage1//src/main/java/com/ryan/stage1/model4/task17/file/myFile.txt", true);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter1 != null && fileWriter2 != null) {
                //关闭资源
                try {
                    /**
                     * 5. 关闭流对象释放有关的资源
                     */
                    fileWriter1.close();
                    fileWriter2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
