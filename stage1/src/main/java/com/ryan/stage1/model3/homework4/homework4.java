package com.ryan.stage1.model3.homework4;

import java.util.List;
import java.util.Scanner;

public class homework4 {

    public static void main(String[] args) {


        while(true) {
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
                        Student student = new Student(Integer.parseInt(sid), name, Integer.parseInt(age));
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
                        Student student = new Student(Integer.parseInt(usid), uname, Integer.parseInt(uage));
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
                    if (Operation.delete(Integer.parseInt(delete))) {
                        System.out.println("删除成功！！");
                        break;
                    }
                    System.out.println("删除失败！！");
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
