package com.ryan.stage1.model5.task22.homework.server;


import com.ryan.stage1.model5.task22.homework.common.User;

import java.io.*;
import java.util.List;

public class main {


    public static void main(String[] args) {
        Server server = null;
        try {
            /**
             * 1. 服务器启动的时候进行加载学生用户信息
             */
            server = new Server();
            FileInputStream fileInputStream = new FileInputStream("u:/students.txt");
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                List<User> list = (List<User>) objectInputStream.readObject();
                StudentInfo.add(list);
                System.out.println("初始化加载学生用户信息：");
                list.forEach(item -> {
                    System.out.println(item);
                });
            }
            server.init();
            ServerView serverView = new ServerView(server, new ServerDao());
            while (true) {
                serverView.serverReceive();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream("u:/students.txt"));
                List<User> students = StudentInfo.getAll();
                fileOutputStream.writeObject(students);
                System.out.println("保存信息成功！！！");
                server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
