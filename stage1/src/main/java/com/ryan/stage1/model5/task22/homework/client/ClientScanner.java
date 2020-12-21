package com.ryan.stage1.model5.task22.homework.client;

import java.util.Scanner;

public class ClientScanner {

    private static Scanner sc = new Scanner(System.in);

    public static Scanner getScanner() {
        return sc;
    }

    public static void close() {
        sc.close();
    }
}

