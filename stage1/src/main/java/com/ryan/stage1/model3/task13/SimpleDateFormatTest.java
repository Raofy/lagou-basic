package com.ryan.stage1.model3.task13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    public static void main(String[] args) {

        //1. 获取当前时间
        Date date = new Date();

        //2. 构造SimpleDateFormat类型并指定格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //3. 日期 -> 文本
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
