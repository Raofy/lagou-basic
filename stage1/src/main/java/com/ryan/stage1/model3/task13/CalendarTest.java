package com.ryan.stage1.model3.task13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    public static void main(String[] args) {

        //1. 获取Calendar类型的引用
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        //2. 设置指定年月日时分秒信息
        instance.set(2020, 9-1, 9, 9, 9, 9);
        //3. 转化为Date类型对象
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(time);
        System.out.println(format);


        System.out.println("------------向指定字段设置指定值-----------");
        //1. 设置年为2021
        instance.set(Calendar.YEAR, 2021);
        Date time1 = instance.getTime();
        System.out.println(simpleDateFormat.format(time1));


        //2. 设置月增加2
        instance.add(Calendar.MONTH, 2);
        Date time2 = instance.getTime();
        System.out.println(simpleDateFormat.format(time2));

    }
}
