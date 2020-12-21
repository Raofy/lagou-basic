package com.ryan.stage1.model4.homework4;

import java.io.Serializable;

public class UserMessage implements Serializable {

    private String status;

    private User user;

    public UserMessage() {
    }

    public UserMessage(String status, User user) {
        this.status = status;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                "status='" + status + '\'' +
                ", user=" + user +
                '}';
    }
}
