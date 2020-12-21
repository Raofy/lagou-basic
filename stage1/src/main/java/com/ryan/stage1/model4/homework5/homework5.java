package com.ryan.stage1.model4.homework5;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Map;

/**
 * 使用基于 tcp 协议的编程模型实现多人同时在线聊天和传输文件，要求每个客户端将发 送的聊天内容和文件发送到服务器，服务器接收到后转发给当前所有在线的客户端。
 */
public class homework5 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;


        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动成功！！！");
            while (true) {
                /**
                 * 1. 监听端口建立连接
                 */
                Socket accept = serverSocket.accept();

                /**
                 * 2. 记录客户端的socket
                 */
                ClientList.getInstance().add(accept);

                /**
                 * 3. 单独开启一条线程进行服务
                 */
                new TcpServer(accept).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
