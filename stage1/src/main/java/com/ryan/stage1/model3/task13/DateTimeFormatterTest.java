package com.ryan.stage1.model3.task13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterTest {

    public static void main(String[] args) {

        //1. 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        //2. 创建指定时间格式的DateTimeFormatter类
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //3. 格式化时间输出
        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        //4. String -> Date
        TemporalAccessor parse = dateTimeFormatter.parse(format);
        System.out.println(parse);
    }
}
