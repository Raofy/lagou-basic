package com.ryan.stage1.model5.task22.homework.server;

import com.ryan.stage1.model4.homework1.Student;
import com.ryan.stage1.model5.task22.homework.common.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 编程实现数据的存取
 */
public class ServerDao {

    /**
     * 编程实现管理员账号和密码的校验并将结果返回出去
     * @param user
     * @return
     */
    public boolean serverManagerCheck(User user) {
        if ("admin".equals(user.getName()) && "123456".equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean serverUserCheck(User user) {
        List<User> all = StudentInfo.getAll();
        for (User item : all) {
            if (item.getName().equals(user.getName()) && item.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 添加学生用户信息
     */
    public void saveUser(User user) {
        List<User> add = StudentInfo.add(user);
    }

    /**
     * 获取全部用户信息
     */
    public List<User> getAll() {
        return StudentInfo.getAll();
    }

    /**
     * 删除指定用户
     */
    public boolean delete(String name) {
        return StudentInfo.delete(name);
    }

    /**
     * 修改用户
     */
    public boolean update(User user) {
        return StudentInfo.update(user);
    }
}