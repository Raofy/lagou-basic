package com.ryan.stage1.model4.homework1;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * 基于学生信息管理系统增加以下两个功能：
 *
 *   a.自定义学号异常类和年龄异常类，并在该成员变量不合理时产生异常对象并抛出。
 *
 *   b.当系统退出时将 List 集合中所有学生信息写入到文件中，当系统启动时读取文件中所 有学生信息到 List 集合中。
 */
public class homework1 {

    public static void main(String[] args) {

        /**
         * 读取文件信息
         */
        try {
            FileInputStream fileInputStream = new FileInputStream("u:/students.txt");
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                List<Student> list = (List<Student>) objectInputStream.readObject();
                Operation.add(list);
                System.out.println("初始化加载学生信息：");
                list.forEach(item -> {
                    System.out.println(item);
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        while (true) {
            Scanner in = new Scanner(System.in);

            System.out.println("-----------请选择功能-------------");
            System.out.println("1.获取全部信息；2.增加；3.更新；4.删除；(输入0退出)");
            String next = in.next();
            switch (next) {
                case "1":
                    Operation.getAll().forEach(item -> {
                        System.out.println(item);
                    });
                    break;
                case "2":
                    System.out.println("请求输入添加的学生信息（学号 姓名 年龄）");
                    String sid = in.next();
                    String name = in.next();
                    String age = in.next();
                    if (sid != null && name != null & age != null) {
                        Student student = new Student(sid, name, Integer.parseInt(age));
                        List<Student> add = Operation.add(student);
                        add.forEach(item -> {
                            System.out.println(item);
                        });
                    }
                    break;
                case "3":
                    System.out.println("请求输入更新的学生信息（学号 姓名 年龄）");
                    String usid = in.next();
                    String uname = in.next();
                    String uage = in.next();
                    if (usid != null && uname != null & uage != null) {
                        Student student = new Student(usid, uname, Integer.parseInt(uage));
                        if (Operation.update(student)) {
                            System.out.println("更新成功");
                            break;
                        }
                        System.out.println("更新失败");
                    }
                    break;
                case "4":
                    System.out.println("请求输入删除的学生学号");
                    String delete = in.next();
                    if (Operation.delete(delete)) {
                        System.out.println("删除成功！！");
                        break;
                    }
                    System.out.println("删除失败！！");
                    break;
                default:
                    try {
                        ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream("u:/students.txt"));
                        List<Student> students = com.ryan.stage1.model4.homework1.Operation.getAll();
                        fileOutputStream.writeObject(students);
                        System.out.println("保存信息成功！！！");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
            }
        }
    }
}
