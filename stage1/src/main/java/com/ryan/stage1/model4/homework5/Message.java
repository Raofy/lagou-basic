package com.ryan.stage1.model4.homework5;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Message {

    private static String message;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Message.message = message;
    }


    /**
     * 群发消息
     */
    /**
     * 群发消息
     *
     */
    public static void group() {
        ClientList.getInstance().forEach(item -> {
            try {
                PrintStream printStream = new PrintStream(item.getOutputStream());
                printStream.println(message);
                printStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void file(byte[] cache) {
        ClientList.getInstance().forEach(item -> {
            PrintStream printStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                printStream = new PrintStream(item.getOutputStream());
//                printStream.println("file");
                bufferedOutputStream = new BufferedOutputStream(item.getOutputStream());
                bufferedOutputStream.write(cache);
                bufferedOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                printStream.close();
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
