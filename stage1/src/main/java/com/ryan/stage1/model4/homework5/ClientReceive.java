package com.ryan.stage1.model4.homework5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientReceive extends Thread {

    private Socket socket;

    public ClientReceive(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        receive();
    }

    public void receive() {
        BufferedReader br = null;

        try {
            while (true) {
                File file = new File("u:/myFile1");
                file.mkdir();
                // 1.使用输入输出流进行通信
//                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 实现接收服务器发来的字符串内容并打印
//                String str2 = br.readLine();
//                if ("file".equals(str2)) {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
                    byte[] cache = new byte[bufferedInputStream.available()];
                    bufferedInputStream.read(cache);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("u:/myFile1/json.txt"));
                    bufferedOutputStream.write(cache);
                    bufferedOutputStream.flush();
//                }
//                System.out.println(str2);
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
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
