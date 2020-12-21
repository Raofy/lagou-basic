# 第十三章 可变长字符串和日期相关类

## 13.1 可变长字符串类（重点）

### 13.1.1 基本概念

背景：因为String类描述的字符串内容是个常量不可以改变，但是有的时候我们需要描述大量长度变动的字符串时，
只能单纯的申请内存，此时会造成空间上的浪费。

解决问题：StringBuilder和StringBuffer类可以描述可以改变的字符串。

区别：StringBuffer是1.0存在，线程安全，效率低；StringBuilder是1.5提出，线程不安全，效率高。

### 13.1.2 StringBuilder常用构造方法

- StringBuilder()

- StringBuilder(int capacity)

- StringBuilder(String str)

- 代码demo

  ```java
  System.out.println("------StringBuilder类方法-------");
  
  //1. 无参构造
  StringBuilder stringBuilder1 = new StringBuilder();
  System.out.println("stringBuilder1 = " + stringBuilder1);
  System.out.println("容量是：" + stringBuilder1.capacity());
  System.out.println("长度是：" + stringBuilder1.length());

  //2. 指定容量构造
  System.out.println("----------指定容量构造------------");
  StringBuilder stringBuilder2 = new StringBuilder(20);
  System.out.println("stringBuilder2 = " + stringBuilder2);
  System.out.println("容量是：" + stringBuilder2.capacity());
  System.out.println("长度是：" + stringBuilder2.length());

  //3. 指定字符串构造
  System.out.println("---------- 指定字符串构造------------");
  StringBuilder stringBuilder3 = new StringBuilder("jlsjljg");
  System.out.println("stringBuilder3 = " + stringBuilder3);
  System.out.println("容量是：" + stringBuilder3.capacity());
  System.out.println("长度是：" + stringBuilder3.length());
  ```

### 13.1.3 StringBuilder常用成员方法和StringBuilder与String之间的转换

- 常用方法

  ```java
  //3. 指定字符串构造
  System.out.println("---------- 指定字符串构造------------");
  StringBuilder stringBuilder3 = new StringBuilder("jlsjljg");
  System.out.println("stringBuilder3 = " + stringBuilder3);
  System.out.println("容量是：" + stringBuilder3.capacity());
  System.out.println("长度是：" + stringBuilder3.length());

  //4. 插入和追加字符串内容
  System.out.println("---------- 插入和追加字符串内容------------");
  StringBuilder stringBuilder4 = stringBuilder3.insert(0, "fuyi");
  System.out.println("stringBuilder4 = " + stringBuilder4);
  System.out.println(stringBuilder3 == stringBuilder4);
  //末尾追加字符串
  stringBuilder4.append("china");
  System.out.println(stringBuilder3);

  //5. 删除字符串
  System.out.println("----------删除字符串 ------------");
  //每次删除一个字符，后面的字符会在往前补位，下标会发生变化
  stringBuilder3.deleteCharAt(0);
  System.out.println(stringBuilder3);
  //删除下标为0-3的字符
  stringBuilder3.delete(0, 3);
  System.out.println(stringBuilder3);

  //6. 替换内容和字符串翻转
  System.out.println("---------替换内容和字符串翻转--------");
  stringBuilder3.setCharAt(0, 'F');
  System.out.println(stringBuilder3);
  // 修改字符串
  stringBuilder3.replace(0, 3, "fu");
  System.out.println(stringBuilder3);
  // 翻转字符串
  stringBuilder3.reverse();
  System.out.println(stringBuilder3);
  ```            
  
- StringBuilder与String之间的转换

  ```java
  //3. 指定字符串构造
  System.out.println("---------- 指定字符串构造------------");
  StringBuilder stringBuilder3 = new StringBuilder("jlsjljg");
  System.out.println("stringBuilder3 = " + stringBuilder3);
  System.out.println("容量是：" + stringBuilder3.capacity());
  System.out.println("长度是：" + stringBuilder3.length());
  
  //7. StringBuilder <-> String
  String s = stringBuilder3.toString();
  StringBuilder stringBuilder = new StringBuilder(s);
  StringBuilder stringBuilder5 = new StringBuilder("1");
  StringBuilder stringBuilder6 = new StringBuilder("2");
  StringBuilder append = stringBuilder5.append(stringBuilder6);
  stringBuilder6 = stringBuilder5;
  System.out.println(stringBuilder5);
  System.out.println(stringBuilder6);
  ```

### 13.1.4 StringBuilder扩容机制

默认扩容机制：原始用量*2+2

### 13.1.5 笔试考点

- StringBuilder类对象本身可以修改，为什么成员方法还有返回值呢？

为了链式编程，简化代码

- 如何实现StringBuilder与String对象间转换？

- String、StringBuilder和StringBuffer三者效率问题？

  String < StringBuffer < StringBuilder

- Idea快捷键

  Ctrl+Alt+左右方向键 返回代码的上次位置

## 13.2 JDK8之前的日期相关类（熟悉）

### 13.2.1 System类


- 作用：提供有用的类字段和方法

- 常用方法：

  - static long currentTimeMillis() 获取距离1970.01.01.00.00.00的毫秒数（通常用于测试代码的执行效率）

### 13.2.2 Date类

- 作用：Date类表示特定的时间瞬间，精度为毫秒

- 常见构造方法

  ```java
  //1. 无参构造
  Date date1 = new Date();
  System.out.println(date1);                 //Tue Nov 24 11:08:31 CST 2020

  //2. 指定毫秒数构造
  Date date2 = new Date(30000);
  System.out.println(date2);                 //Thu Jan 01 08:00:30 CST 1970
  ```

- 常用方法：

  - Date()
  
  - Date(long date)

  - long getTime()
  
  - void setTime(long time)
  
  - 代码demo
  
    ```java
    //1. 无参构造
    Date date1 = new Date();
    System.out.println(date1);                 //Tue Nov 24 11:08:31 CST 2020
    
    //3. 获取距离1970.01.01.00:00:00的毫秒数
    long time = date1.getTime();
    System.out.println(time);                  //1606187311955

    //4. 设置调用对象为距离基准时间多少毫秒的时间点
    date1.setTime(1000);
    System.out.println(date1);                 //Thu Jan 01 08:00:01 CST 1970
    ```
  
  
### 13.2.3 SimpleDateFormat类

- 作用：实现日期和文本之间的转换

- 常用方法

  - SimpleDate()
  
  - SimpleDateFormat(String pattern)
  
  - format(Date date)     日期 -> 文本
  
  - Date parse(String source)  文本 -> 日期
  
  ```java
  //1. 获取当前时间
  Date date = new Date();

  //2. 构造SimpleDateFormat类型并指定格式
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  //3. 日期 -> 文本
  String format = simpleDateFormat.format(date);
  System.out.println(format);
  ```

### 13.2.4 Calendar类  

- 作用：取代Date()，指定年月日时分秒构造对象

- 常用方法：

  - getInstance()      获取实例对象
  
- 代码demo

  ```java
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
  ```
  
- 考点

Calendar既然是个抽象类不能创建对象，那为什么还能通过getInstance获取Calendar类型的引用呢？
解析：追溯getInstance()方法底层源码，底层实现多态。返回的是实现Calendar的子类。

## 13.3 JDK8中的日期相关类

### 13.3.1 JDK8日期类由来

JDK8之前的日期类不能很好的兼容国际性，所以JDK8退出新的日期类

### 13.3.2 JDK8日期类概述

- java.time.LocalDate类主要用于描述年-月-日格式的日期信息，该类不表示时间和时区信息。

- java.time.LocalTime 类主要用于描述时间信息，可以描述时分秒以及纳秒。

- java.time.LocalDateTime类主要用于描述ISO-8601日历系统中没有时区的日期时间，如2007-12-03T10:15:30。

### 13.3.3 LocalDate类、LocalTime类和LocalDateTime类

- 代码demo

  ```java
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

  ```

- Idea快捷键
  
  Ctrl + F12查找该类中的所有方法

### 13.3.4 Instant类

描述瞬间的时间点信息

- 代码demo
  
  ```java
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
  ```

### 13.3.5 DateTimeFormatter类

- 作用：用于打印和解析日期时间对象的格式化

- 代码demo

  ```java
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
  ```
  
  