package com.ryan.stage1.model4.task17;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamTest {

    public static void main(String[] args) {

        BufferedInputStream bis = null;

        System.out.println("-------------------构造方法-------------------");

        try {
            new BufferedInputStream(new FileInputStream("e:/myFile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
