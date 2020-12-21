package com.ryan.stage1.model5.task22.homework.server;

import com.ryan.stage1.model5.task22.homework.common.User;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class StudentInfo {

    /**
     * 存储学生信息
     */
    private static List<User> students = new LinkedList();


    /**
     * 获取全部学生
     *
     * @return
     */
    public static List<User> getAll() {
        return students;
    }

    /**
     * 增加学生信息
     *
     * @param list
     * @return
     */
    public static List<User> add(List<User> list) {
        students = list;
        return students;
    }

    /**
     * 增加学生信息
     *
     * @param student
     * @return
     */
    public static List<User> add(User student) {
        students.add(student);
        return students;
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    public static boolean update(User student) {
        AtomicBoolean flag = new AtomicBoolean(false);
        students.forEach(item -> {
            if (item.getName().equals(student.getName())) {
                item.setPassword(student.getPassword());
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
    public static boolean delete(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
