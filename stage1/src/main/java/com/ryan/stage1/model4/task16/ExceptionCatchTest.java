package com.ryan.stage1.model4.task16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionCatchTest {

    public static void main(String[] args) {

        try {
            //创建一个文件输入流，并与E盘目录下的NettyDemodata.json文件建立关系
            System.out.println("1");
            FileInputStream fileInputStream = new FileInputStream("d:\\NettyDemodata.json");
            System.out.println("2");
            fileInputStream.close();
            System.out.println("3");
        }
        catch (FileNotFoundException e) {
            System.out.println("4");
            e.printStackTrace();
            System.out.println("5");
        }
        catch (IOException e) {
            System.out.println("6");
            e.printStackTrace();
            System.out.println("7");
        }

        System.out.println("程序执行完毕！！");

        //当文件存在的时候，程序运行结果为：           1 -> 2 -> 3 -> 程序执行完毕！！
        //如果将E盘改为D盘作为文件不存在例子，运行结果：1 -> 4 -> java.io.FileNotFoundException: d:\NettyDemodata.json (系统找不到指定的文件。) -> 5 -> 程序执行完毕！！
        //如果不捕获FileNotFoundException，运行结果： 1 -> 6 -> java.io.FileNotFoundException: d:\NettyDemodata.json (系统找不到指定的文件。) -> 7 -> 程序执行完毕！！
    }
}
