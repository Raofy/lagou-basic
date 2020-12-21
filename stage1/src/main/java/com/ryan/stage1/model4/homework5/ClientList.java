package com.ryan.stage1.model4.homework5;

import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.*;

public class ClientList {

    private ClientList(){

    }

    private static List<Socket> clients = null;

    public static synchronized List<Socket> getInstance(){
        if(clients == null){
            clients = new LinkedList<>();;
        }
        return clients;
    }

    public static void addClient(Socket channel) {
        clients.add(channel);
    }
}
