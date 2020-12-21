package com.ryan.stage1.model3.homework4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Operation {

    /**
     * 存储学生信息
     */
    private static List<Student> students = new LinkedList();


    /**
     * 获取全部学生
     *
     * @return
     */
    public static List<Student> getAll() {
        return students;
    }


    /**
     * 增加学生信息
     *
     * @param student
     * @return
     */
    public static List<Student> add(Student student) {
        students.add(student);
        return students;
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    public static boolean update(Student student) {
        AtomicBoolean flag = new AtomicBoolean(false);
        students.forEach(item -> {
            if (item.getSid() == student.getSid()) {
                item.setAge(student.getAge());
                item.setName(student.getName());
                flag.set(true);
            }
        });
        return flag.get();
    }

    /**
     * 删除学生
     *
     * @param id
     * @return
     */
    public static boolean delete(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSid() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
