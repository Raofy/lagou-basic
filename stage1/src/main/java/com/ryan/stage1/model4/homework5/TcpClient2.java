package com.ryan.stage1.model4.homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient2 {

    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        Scanner sc = null;
        BufferedReader br = null;

        try {
            // 1.创建Socket类型的对象并提供服务器的主机名和端口号
            s = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功！");
            System.out.println("本地IP是：" + s.getLocalSocketAddress().toString());

            /**
             * 开启线程去接收信息
             */
            new ClientReceive(s).start();

            // 2.使用输入输出流进行通信
            sc = new Scanner(System.in);
            ps = new PrintStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            while(true) {
                // 实现客户端发送的内容由用户从键盘输入
                System.out.println("请输入要发送的数据内容：");
                String str1 = sc.next();
                // 实现客户端向服务器发送字符串内容
                ps.println(str1);
                System.out.println("客户端发送数据内容成功！");
                // 当发送的数据内容为"bye"时，则聊天结束
                if ("bye".equalsIgnoreCase(str1)) {
                    System.out.println("聊天结束！");
                    break;
                }
            }

        } catch (IOException e) {
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
                ps.close();
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
