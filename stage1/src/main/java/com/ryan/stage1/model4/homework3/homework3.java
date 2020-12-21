package com.ryan.stage1.model4.homework3;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
 */
public class homework3 {

    public static void main(String[] args) {

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();

        /**
         * 2. 创建一个线程池
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /**
         * 3. 向线程池中布置任务
         */
        executorService.submit(new FileCopyCallable("u:/deleteFile","u:/copyDeleteFile"));
        //executorService.submit(new FileCopyCallable("u:/deleteFile","u:/folder"));

        /**
         * 4. 关闭线程池
         */
        executorService.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("串行拷贝花费：" + (end - start) + "ms");                   //32ms
        System.out.println("线程池拷贝花费：" + (end - start) + "ms");                 //4ms
    }








    /**
     * 拷贝指定目录中的所有内容（拷贝文件和目录）
     *
     * @param originURL
     * @param newURL
     */
    public static void copy(String originURL, String newURL) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        File newFolder = null;
        File newFile = null;
        File file = new File(originURL);
        File[] files = file.listFiles();
        if (files.length > 0) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    String newFolderURL = String.format("%s/%s", newURL, file1.getName());
                    newFolder = new File(newFolderURL);
                    System.out.println(newFolder.mkdirs() ? "创建目录成功":"创建目录失败");
                    copy(file1.getPath(), newFolder.getAbsolutePath());
                } else {
                    try {
                        new File(newURL).mkdirs();
                        String newFileURL = String.format("%s/%s", newURL, file1.getName());
                        newFile = new File(newFileURL);
                        fileInputStream = new FileInputStream(file1.getPath());
                        fileOutputStream = new FileOutputStream(newFile);
                        byte[] cache = new byte[1024];
                        int length = 0;
                        while ((length = fileInputStream.read(cache)) != -1) {
                            fileOutputStream.write(cache, 0, length);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}

