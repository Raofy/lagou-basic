package com.ryan.stage1.model3.task13;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class InstantTest {

    public static void main(String[] args) {

        //1. 获取当前系统时间 并不是当前系统的默认时区
        Instant now = Instant.now();
        System.out.println(now);

        //2. 加上时区的8小时
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("加上偏移后的时间为：" + offsetDateTime);

        //3. 获取当前对象距离基准时间的毫秒数
        long l = now.toEpochMilli();
        System.out.println(l);

        //4. 指定毫秒数进行构造对象
        Instant instant = Instant.ofEpochMilli(l);
        System.out.println(instant);
    }
}
