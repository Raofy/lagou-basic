package com.ryan.stage1.model4.homework4;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用基于 tcp 协议的编程模型实现将 UserMessage 类型对象由客户端发送给服务器；
 * <p>
 * 服 务 器接 收到 对象 后判 断 用户 对象 信息 是否 为 "admin" 和 "123456"， 若 是则 将 UserMessage 对象中的类型改为"success"，否则将类型改为"fail"并回发给客户端，客户 端接收到服务器发来的对象后判断并给出登录成功或者失败的提示。
 * <p>
 * 其中 UserMessage 类的特征有：类型(字符串类型) 和 用户对象(User 类型)。
 * <p>
 * 其中 User 类的特征有：用户名、密码(字符串类型)。
 * <p>
 * 如：
 * <p>
 * UserMessage tum = new UserMessage("check", new User("admin", "123456"));
 */
public class homework4 {

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        ObjectInputStream br = null;
        ObjectOutputStream ps = null;

        try {
            // 1.创建ServerSocket类型的对象并提供端口号
            ss = new ServerSocket(8888);

            // 2.等待客户端的连接请求，调用accept方法
            System.out.println("等待客户端的连接请求...");
            // 当没有客户端连接时，则服务器阻塞在accept方法的调用这里
            s = ss.accept();
            System.out.println("客户端" + s.getInetAddress() + "连接成功！");

            // 3.使用输入输出流进行通信
            ps = new ObjectOutputStream(s.getOutputStream());
            br = new ObjectInputStream(s.getInputStream());
            // 实现对客户端发来字符串内容的接收并打印
            // 当没有数据发来时，下面的方法会形成阻塞
            UserMessage userMessage = (UserMessage) br.readObject();
            System.out.println("接收到客户端信息为：" + userMessage);
            if ("123456".equals(userMessage.getUser().getPassword())) {
                userMessage.setStatus("success");
            } else {
                userMessage.setStatus("fail");
            }
            ps.writeObject(userMessage);
            System.out.println("服务器发送数据成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
