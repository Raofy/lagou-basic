package com.ryan.stage1.model4.homework2;

import java.io.File;
import java.io.IOException;

/**
 * 实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
 */
public class homework2 {

    /**
     * 删除指定目录中的所有内容（只删除文件）
     *
     * @param path
     */
    public static void delete1(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                System.out.println("目录名称是：" + file1.getName());
                System.out.println(file1.delete()? "文件删除成功": "文件删除失败");
            } else {
                delete1(file1.getPath());
            }
        }
    }

    /**
     * 删除指定目录中的所有内容（删除文件和目录）
     *
     * @param path
     */
    public static void delete2(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files.length > 0) {
            for (File file1 : files) {
                if (file1.isFile()) {
                    file1.delete();
                } else {
                    delete2(file1.getPath());
                }
            }
        }
        file.delete();
    }


    public static void main(String[] args) {

        /**
         * 1. 创建目录和文件，用于测试删除
         */
        try {
            File directory1 = new File("u:/deleteFile/folder1/");
            File directory2 = new File("u:/deleteFile/folder2/");
            File directory3 = new File("u:/deleteFile/folder1/subFolder3/");
            directory1.mkdirs();
            directory2.mkdirs();
            directory3.mkdirs();
            File file1 = new File("u:/deleteFile/folder1/file1.txt");
            File file2 = new File("u:/deleteFile/folder2/file2.png");
            File file3 = new File("u:/deleteFile/file3.md");
            File file4 = new File("u:/deleteFile/folder1/subFolder3/text.java");
            File file5 = new File("u:/deleteFile/folder1/subFolder3/小电影.avi");
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            file4.createNewFile();
            file5.createNewFile();

            //删除
            delete2("u:/deleteFile");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
