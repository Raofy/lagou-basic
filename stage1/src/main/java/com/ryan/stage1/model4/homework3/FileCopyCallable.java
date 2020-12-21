package com.ryan.stage1.model4.homework3;

import java.io.*;
import java.util.concurrent.Callable;

public class FileCopyCallable implements Callable {

    /**
     * 原始路径
     */
    private String originURL;

    /**
     * 新的路径
     */
    private String newURL;


    @Override
    public Object call() throws Exception {
        /**
         * 拷贝文件
         */
        this.copy(getOriginURL(), getNewURL());
        return true;
    }


    /**
     * 拷贝指定目录中的所有内容（拷贝文件和目录）
     *
     * @param originURL
     * @param newURL
     */
    public void copy(String originURL, String newURL) {
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

    public FileCopyCallable(String originURL, String newURL) {
        this.originURL = originURL;
        this.newURL = newURL;
    }

    public String getOriginURL() {
        return originURL;
    }

    public void setOriginURL(String originURL) {
        this.originURL = originURL;
    }

    public String getNewURL() {
        return newURL;
    }

    public void setNewURL(String newURL) {
        this.newURL = newURL;
    }
}
