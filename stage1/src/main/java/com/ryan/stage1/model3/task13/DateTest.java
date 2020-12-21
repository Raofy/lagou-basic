package com.ryan.stage1.model3.task13;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {

        //1. 无参构造
        Date date1 = new Date();
        System.out.println(date1);                 //Tue Nov 24 11:08:31 CST 2020

        //2. 指定毫秒数构造
        Date date2 = new Date(30000);
        System.out.println(date2);                 //Thu Jan 01 08:00:30 CST 1970

        //3. 获取距离1970.01.01.00:00:00的毫秒数
        long time = date1.getTime();
        System.out.println(time);                  //1606187311955

        //4. 设置调用对象为距离基准时间多少毫秒的时间点
        date1.setTime(1000);
        System.out.println(date1);                 //Thu Jan 01 08:00:01 CST 1970
    }
}
