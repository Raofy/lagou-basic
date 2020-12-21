package com.ryan.stage1.model4.task17;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

    public static void main(String[] args) {

        DataOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("e:/myFile.txt"));

            System.out.println("-------------------常用方法---------------------");

            /**
             * 1. 用于将参数指定的整数一次性写入输出流，优先写入高字节
             */
            dataOutputStream.writeInt(67);             //   C
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != dataOutputStream) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
