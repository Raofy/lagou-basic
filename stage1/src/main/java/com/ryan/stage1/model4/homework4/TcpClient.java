package com.ryan.stage1.model4.homework4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {

    public static void main(String[] args) {

        Socket s = null;
        ObjectOutputStream ps = null;
        Scanner sc = null;
        ObjectInputStream br = null;

        try {
            // 1.创建Socket类型的对象并提供服务器的主机名和端口号
            s = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功！");

            // 2.使用输入输出流进行通信
            ps = new ObjectOutputStream(s.getOutputStream());
            br = new ObjectInputStream(s.getInputStream());

            // 3.实现客户端向服务器发送字User对象
            UserMessage userMessage = new UserMessage("check", new User("fuyi", "123456"));
            ps.writeObject(userMessage);
            System.out.println("客户端发送数据内容成功！");
            // 实现接收服务器发来的字符串内容并打印
            UserMessage userMessage1 = (UserMessage) br.readObject();
            System.out.println("服务器回发的消息是：" + userMessage1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭Socket并释放有关的资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != ps) {
                try {
                    ps.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != sc) {
                sc.close();
            }
            if (null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
