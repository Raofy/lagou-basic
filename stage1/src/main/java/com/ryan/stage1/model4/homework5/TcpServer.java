package com.ryan.stage1.model4.homework5;

import java.io.*;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TcpServer extends Thread {

    private Socket socket;


    byte[] cache = new byte[8192];

    public TcpServer(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        PrintStream ps = null;
        StringBuffer info = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        while (true) {
        try {
//                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                if ("file".equals(bufferedReader.readLine())) {
            bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            byte[] cache = new byte[bufferedInputStream.available()];

            bufferedInputStream.read(cache);
            new FileOutputStream("e:/myFile1/json.txt").write(cache);
//                    Message.file(cache);
//                };
//                simpleDateFormat.format(new Date(System.currentTimeMillis()));
//                System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())) + "  " + "服务器接收到客户端" + socket.getInetAddress().toString() + ":" + socket.getPort() + "发送过来的消息：" + Message.getMessage());
//                Message.setMessage(socket.getInetAddress().toString() + ":" + socket.getPort() + ":" + bufferedReader.readLine());
//                Message.group();
            System.out.println("服务器发送消息成功！！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
//        }
    }

}
