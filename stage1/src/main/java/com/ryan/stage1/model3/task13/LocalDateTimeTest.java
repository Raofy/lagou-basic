package com.ryan.stage1.model3.task13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest {


    public static void main(String[] args) {

        //1. 当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        //2. 当前时间
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);

        //3. 获取当前日期和时间
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        //4. 使用参数指定日期时间
        LocalDateTime localDateTime = LocalDateTime.of(2020, 9, 9, 9, 9, 9);
        System.out.println("获取当前月的第几天：" + localDateTime.getDayOfMonth());
        System.out.println("当前星期的第几天" + localDateTime.getDayOfWeek());
        System.out.println("当前年的第几天" + localDateTime.getDayOfYear());
        System.out.println("当前年份" + localDateTime.getYear());
        System.out.println("当前月份" + localDateTime.getMonthValue());
        System.out.println("当前小时" + localDateTime.getHour());
        System.out.println("当前分钟" + localDateTime.getMinute());
        System.out.println("当前秒数" + localDateTime.getSecond());


        System.out.println("-----------设置年月日时分秒--------------");

        //1. 设置年
        LocalDateTime localDateTime1 = localDateTime.withYear(2021);
        System.out.println(localDateTime1);
        //输入结果为false，可以看出与String类似，当设置年份后，会重新创建一个对象，原来的对象不改变。
        System.out.println(localDateTime == localDateTime1);                   //false

        //2. 增加操作
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime2);                                    //2020-12-09T09:09:09


        //3. 减少操作
        LocalDateTime localDateTime3 = localDateTime.minusDays(5);
        System.out.println(localDateTime3);                                    //2020-09-04T09:09:09


    }

}
