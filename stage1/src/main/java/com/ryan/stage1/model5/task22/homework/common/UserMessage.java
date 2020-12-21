package com.ryan.stage1.model5.task22.homework.common;

import java.io.Serializable;

public class UserMessage implements Serializable {

    private String check;

    private User user;

    public UserMessage(String check, User user) {
        this.check = check;
        this.user = user;
    }

    public UserMessage() {
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserMessage{" +
                "check='" + check + '\'' +
                ", user=" + user +
                '}';
    }
}
