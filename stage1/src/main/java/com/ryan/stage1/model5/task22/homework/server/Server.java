package com.ryan.stage1.model5.task22.homework.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket = null;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void init() throws IOException {
       serverSocket = new ServerSocket(8889);
        Socket client = serverSocket.accept();
        System.out.println("新的客户端连接进来了。。。。");
        ois = new ObjectInputStream(client.getInputStream());
        oos = new ObjectOutputStream(client.getOutputStream());
    }

    public void close() throws IOException {
        if (null != serverSocket) {
            serverSocket.close();
        }
    }
}
