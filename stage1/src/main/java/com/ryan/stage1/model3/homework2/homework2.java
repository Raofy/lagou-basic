package com.ryan.stage1.model3.homework2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class homework2 {

    /**
     * 获取两指定字符串的交集子串
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();
            //小串在前面
            if (str1.length() > str2.length()) {
                String temp = str2;
                str2 = str1;
                str1 = temp;
            }

            int n = str1.length();
            int m = str2.length();
            Set<String> set = new TreeSet<>();
            int flag = 0;

            //字符串长度
            for (int i = n; i > 0; i--) {
                System.out.println();
                System.out.println(i + "位");

                //枚举长度为i的所有子串
                for (int j = 0; j < n - i + 1; j++) {
                    String substring = str1.substring(j, j + i);
                    System.out.print(substring + "    ");
                    if (str2.contains(substring)) {
                        flag = 1;
                        set.add(str1.substring(j, i + j));
                    }
                }
                if (flag == 1) break;
            }
            System.out.println();
            set.forEach(e -> System.out.println("最长字串为" + e));
        }
    }
}

