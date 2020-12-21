package com.ryan.stage1.model5.task22.homework.client;

import com.ryan.stage1.model4.homework1.Operation;
import com.ryan.stage1.model4.homework1.Student;
import com.ryan.stage1.model5.task22.homework.common.User;
import com.ryan.stage1.model5.task22.homework.common.UserMessage;
import com.ryan.stage1.model5.task22.homework.server.StudentInfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class ClientView {

    private client ci;

    public ClientView(client ci) {
        this.ci = ci;
    }

    public client getCi() {
        return ci;
    }

    public void clientMainPage() throws IOException, ClassNotFoundException {
        while(true) {
            System.out.println("  \n\n\t\t   在线考试系统");
            System.out.println("-------------------------------------------");
            System.out.print("   [1] 学员系统");
            System.out.println("     [2] 管理员系统");
            System.out.println("   [0] 退出系统");
            System.out.println("-------------------------------------------");
            System.out.println("请选择要进行的业务编号：");
            int choose = ClientScanner.getScanner().nextInt();
            switch (choose) {
                case 1:
                    clientUserLogin();
                    System.out.println("正在进入学员系统...");
                    break;
                case 2:
                    clientManagerLogin();
                    break;
                case 0:
                    System.out.println("正在退出系统...");
                    return;
                default:
                    System.out.println("输入错误，请重新选择！");
            }
        }
    }

    private void clientManagerLogin() throws IOException, ClassNotFoundException {
        // 1.准备管理员登录的相关数据
        System.out.println("请输入管理员的账户信息：");
        String userName = ClientScanner.getScanner().next();
        System.out.println("请输入管理员的密码信息：");
        String password = ClientScanner.getScanner().next();
        UserMessage tum = new UserMessage("managerCheck", new User(userName, password));
        // 2.将UserMessage类型的对象通过对象输出流发送给服务器
        ci.getOos().writeObject(tum);
        System.out.println("客户端发送管理员账户信息成功！");
        // 3.接收服务器的处理结果并给出提示
        tum = (UserMessage) ci.getOis().readObject();
        if ("success".equals(tum.getCheck())) {
            System.out.println("登录成功，欢迎使用！");
            while (true) {

                System.out.println("-----------请选择功能-------------");
                System.out.println("1.获取全部信息；2.增加；3.删除；(输入0退出)");
                int next = ClientScanner.getScanner().nextInt();
                switch (next) {
                    case 1:
                        ci.getOos().writeObject(new UserMessage("getAll", null));
                        // 3.接收服务器的处理结果并给出提示
                        List<User> all = (List<User>) ci.getOis().readObject();
                        all.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("请求输入添加的学生信息（姓名）");
                        String name = ClientScanner.getScanner().next();
                        if (name != null) {
                            User user = new User(name, "123456");
                            ci.getOos().writeObject(new UserMessage("add", user));
                        }
                        break;
                    case 3:
                        System.out.println("请求输入删除的学生名字");
                        String delete = ClientScanner.getScanner().next();
                        if (delete != null) {
                            User user = new User(delete, "123456");
                            ci.getOos().writeObject(new UserMessage("delete", user));
                        }
                        Object o = ci.getOis().readObject();
                        System.out.println(o);
                        break;
                    default:
                        System.exit(0);;
                }
            }
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    private void clientUserLogin() throws IOException, ClassNotFoundException {
        // 1.准备管理员登录的相关数据
        System.out.println("请输入学员的账户信息：");
        String userName = ClientScanner.getScanner().next();
        System.out.println("请输入学员的密码信息(初始为123456)：");
        String password = ClientScanner.getScanner().next();
        UserMessage tum = new UserMessage("userCheck", new User(userName, password));
        // 2.将UserMessage类型的对象通过对象输出流发送给服务器
        ci.getOos().writeObject(tum);
        System.out.println("客户端发送学员账户信息成功！");
        // 3.接收服务器的处理结果并给出提示
        tum = (UserMessage) ci.getOis().readObject();
        if ("success".equals(tum.getCheck())) {
            String studentUser = tum.getUser().getName();
            System.out.println("登录成功，欢迎使用！");
            while (true) {

                System.out.println("-----------请选择功能-------------");
                System.out.println("1.修改密码；(输入0退出)");
                int next = ClientScanner.getScanner().nextInt();
                switch (next) {
                    case 1:
                        System.out.println("请求输入修改的秘密");
                        String pass = ClientScanner.getScanner().next();
                        if (pass != null) {
                            User user = new User(studentUser, pass);
                            ci.getOos().writeObject(new UserMessage("update", user));
                            Object o = ci.getOis().readObject();
                            System.out.println(o);
                        }
                        break;
                    default:
                        System.exit(0);;
                }
            }
        } else {
            System.out.println("用户名或密码错误！");
        }
    }
}
