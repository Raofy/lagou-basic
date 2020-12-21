package com.ryan.stage1.model5.task22.homework.client;

import com.ryan.stage1.model5.task22.homework.common.User;
import com.ryan.stage1.model5.task22.homework.server.StudentInfo;

import java.io.*;
import java.util.List;

public class main {

    public static void main(String[] args) {
        client ci = null;
        ci = new client();
        try {
            ci.init();
            ClientView clientView = new ClientView(ci);
            clientView.clientMainPage();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {

                ci.close();
                ClientScanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
