package com.ryan.stage1.model5.task22.homework.server;

import com.ryan.stage1.model5.task22.homework.common.User;
import com.ryan.stage1.model5.task22.homework.common.UserMessage;

import java.io.IOException;
import java.util.List;

/**
 * 编程实现服务器的主功能
 */
public class ServerView {

    /**
     * 使用合成复用原则
     */
    private Server sic;
    private ServerDao sd;

    /**
     * 通过构造方法实现成员变量的初始化
     * @param sic
     */
    public ServerView(Server sic, ServerDao sd) {
        this.sic = sic;
        this.sd = sd;
    }

    /**
     * 自定义成员方法实现客户端发来消息的接收并处理
     */
    public void serverReceive() throws IOException, ClassNotFoundException {
        UserMessage tum = (UserMessage) sic.getOis().readObject();
        System.out.println("接收到的消息是：" + tum);
        if ("add".equals(tum.getCheck())) {                             // 添加用户信息
            sd.saveUser(tum.getUser());
        } else if ("managerCheck".equals(tum.getCheck())) {             // 调用方法实现管理员账号和密码信息的校验
            if (sd.serverManagerCheck(tum.getUser())) {
                tum.setCheck("success");
            } else {
                tum.setCheck("fail");
            }
            sic.getOos().writeObject(tum);
        } else if ("getAll".equals(tum.getCheck())) {                   // 获取用户
            List<User> all = sd.getAll();
            all.forEach(System.out::println);
            sic.getOos().writeObject(all);
        } else if ("delete".equals(tum.getCheck())) {                   // 删除用户
            if (sd.delete(tum.getUser().getName())){
                sic.getOos().writeObject("删除成功！！！");
            } else {
                sic.getOos().writeObject("删除失败！！！");
            }
        } else if ("update".equals(tum.getCheck())) {                   // 更新用户
            if (sd.update(tum.getUser())){
                sic.getOos().writeObject("更新成功！！！");
            } else {
                sic.getOos().writeObject("更新失败！！！");
            }
        } else if ("userCheck".equals(tum.getCheck())) {                // 用户登录
            if (sd.serverUserCheck(tum.getUser())) {
                tum.setCheck("success");
            } else {
                tum.setCheck("fail");
            }
            sic.getOos().writeObject(tum);
        } else {

        }


        // 将校验结果发送给客户端

        System.out.println("服务器发送校验结果成功！");
    }
}
