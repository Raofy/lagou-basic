package com.ryan.stage1.model5.task22.homework.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

    private Socket socket = null;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ObjectOutputStream getOos() {
        return oos;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void init() throws IOException {
        /**
         * 1. 创建socket对象并指定服务器的地址和端口号
         */
        socket = new Socket(InetAddress.getLocalHost(), 8889);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        System.out.println("连接服务器成功。。。");

    }

    public void close() throws IOException{
        if (null != socket) {
            socket.close();
        }
        oos.close();
        ois.close();
    }
}
