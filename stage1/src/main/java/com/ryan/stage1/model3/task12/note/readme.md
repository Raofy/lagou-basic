# 第十二章 String类的概述和常用方法使用

## 12.1 String类的概念（重点）

String类表示字符串。 Java程序中的所有字符串文字（例如“ abc”）都实现为此类的实例。 字符串是常量； 它们的值在创建后无法更改。 字符串缓冲区支持可变字符串。 由于String对象是不可变的，因此可以共享它们。 例如：

   
    String str = "abc";
  
 
等价于:

     char data[] = {'a', 'b', 'c'};
     String str = new String(data);

## 12.2 常量池的概念（原理）

因为字符串是通过final关键字修饰的常量，因此JVM将首次出现的字符串放入到常量池里面，如果后续代码中再次出现相同的字符串，直接使用常量池里面的对象，从而避免申请空间再次创建对象，节省资源开销和提高性能。从另一方面可以得出String类字符串在底层是实现资源共享机制的。

## 12.3 常用构造方法（熟练）

- 代码demo

  ```java
  System.out.println("----------------常用构造方法------------------");
  
  //1. 无参构造方法
  //结果：创建了对象，但是对象里面没有内容
  String str1 = new String();
  System.out.println("无参构造打印：" + str1);       //""

  //2. 通过字节数组构造
  byte[] arr = {97, 98, 99, 100, 101};             //abcde
  String str2 = new String(arr);
  System.out.println("字节数组构造：" + str2);       //abcde

  String str3 = new String(arr, 2, 2);//cd
  System.out.println("字节数组构造：" + str3);

  //3. 通过字符数组构造
  char[] brr = {'a', 'b', 'c', 'd', 'e'};
  String str4 = new String(brr);
  System.out.println("字符数组构造：" + str2);       //abcde

  String str5 = new String(brr, 2, 3);
  System.out.println("字符数组构造：" + str5);       //cde

  //4. 字符串构造方法
  String str6 = new String("hello world");
  System.out.println("字符串数组构造：" + str6);      //hello world
  ```

## 12.4 String类笔试考点

- 代码demo

  ```java
  System.out.println("------------------笔试常考内容------------------");
  
  //1. 常量池和堆区的内容比较
  String str1 = "abcd";                          //该过程创建一个对象
  String str2 = "abcd";
  String str3 = new String("abcd");      //该过程创建两个对象（1个在常量池中，1个在堆区里面）
  String str4 = new String("abcd");

  System.out.println(str1 == str2);              //true
  System.out.println(str1.equals(str2));         //true
  System.out.println(str3 == str4);              //false
  System.out.println(str3.equals(str4));         //true
  System.out.println(str1 == str3);              //false
  System.out.println(str1.equals(str3));         //true

  System.out.println("----------------------------------------------------");

  //2. 字符串拼接比较
  String str5 = "abcd";
  String str6 = "abc" + "d";

  System.out.println(str5 == str6);              //true
  System.out.println(str5.equals(str6));         //true
  System.out.println(str6 == str3);              //false
  System.out.println(str6.equals(str3));         //true

  System.out.println("----------------------------------------------------");

  //3. 变量与常量拼接比较
  String str7 = "ab";
  String str8 = str7 + "cd";

  System.out.println(str1 == str8);             //false
  System.out.println(str8.equals(str1));        //true
  System.out.println(str8 == str3);             //false
  System.out.println(str8.equals(str3));        //true
  ```

## 12.5 String回文判断

- 代码demo

  ```java
  System.out.println("------------String回文判断--------------");
  
  String str1 = "上海自来水来自海上";
  for (int i = 0; i < str1.length()/2; i++) {
      if (str1.charAt(i) != str1.charAt(str1.length()-1-i)) {
          System.out.println("字符串" + str1 + "不是回文");
          return;
      }
  }
  System.out.println("字符串" + str1 + "是回文");
  ```

## 12.6 String实现字符串之间大小比较

- 代码demo
  
  ```java
  String str1 = "hello";

  System.out.println(str1.compareTo("hetto"));               // 76-84 = -8
  System.out.println(str1.compareTo("gto"));                 // 72-71 = 1
  System.out.println(str1.compareToIgnoreCase("HELLO"));     //0
  ```
## 12.7 String、byte数组和char数组间转换

- 代码demo
 
  ```java
  System.out.println("------------------String、byte数组和char数组间转换-----------------------");
  
  System.out.println("------------------String -> byte数组-----------------------");

  //1. String -> byte[]
  String str1 = "fuyi";
  byte[] brr = str1.getBytes();
  for (byte b : brr) {
      System.out.println(b);
  }

  System.out.println("------------------String -> char数组-----------------------");

  //2. String -> char[]
  char[] crr = str1.toCharArray();
  for (char c : crr) {
      System.out.println(c);
  }
  ```
## 12.8 字符与字符串查找

- 代码demo

  ```java
  String str1 = "Good Good study, Day Day up!";
  String str3 = str1 + "bn";

  int g = str1.indexOf('g');
  System.out.println(g);

  int g1 = str1.indexOf("G");
  System.out.println(g1);

  int g2 = str1.indexOf('G', 1);
  System.out.println(g2);

  //2. 查找字符串
  int day = str1.indexOf("Day");
  System.out.println(day);              //第一次出现的位置

  System.out.println("----------通过上述字符串中出现指定字符串的所有位置--------");

  int pos = 0;
  while ((pos = str1.indexOf("Day", pos)) != -1) {
      System.out.println("pos = " + pos);
      pos += "Day".length();
  }

  System.out.println("-----实现字符串的反向查找-----------");

  int g3 = str1.lastIndexOf('G');
  System.out.println(g3);

  int g4 = str1.lastIndexOf('G', 5);
  System.out.println(g4);

  int day1 = str1.lastIndexOf("Day");
  System.out.println(day1);

  int day2 = str1.lastIndexOf("Day", 5);
  System.out.println(day2);
  ```
  
## 12.9 subString()方法

- 代码demo

  ```java
  String str1 = "Happy Life";
  
  //1. 从下标为3开始截取字符串
  String substring = str1.substring(3);
  System.out.println(substring);

  //2. 截取指定范围内的子字符串
  String substring1 = str1.substring(3, 5);
  System.out.println(substring1);
  ```

## 12.10 正则表达式（了解）

- 概念：本质是一个规则字符串，对字符串数据进行格式校验验证、以及匹配替换、查找等操作。**该字符通常使用^运算符作为开头标志，使用$运算符作为结尾标志，当然也可以省略**

## 12.11 正则表达式相关的方法（熟悉）

- 正则表达式校验

  ```java
  System.out.println("------正则表达式校验----------");
  
  //正则表达式只能对数据格式进行验证，无法对数据内容的正确性进行验证
  //描述银行卡密码的规则：由6位数字组成
  String reg = "[0-9]{6}";

  //要求非0开头的5~15为数字组成
  String reg2 = "[1-9]\\d{4,14}";

  //6位代表地区，4位代表年，2位代表月，2位代表日期，3位代表个人，最后一位有可能是X，共18位
  String reg3 = "(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9|X])";

  //2. 提示用户从控制台输入
  Scanner scanner = new Scanner(System.in);
  while (true) {
      System.out.println("请输入银行卡密码：");
      String next = scanner.next();

      //3. 判断用户输入的银行卡是否满足条件
      if (next.matches(reg)) {
          System.out.println("输入的银行卡密码符合要求");
          break;
      } else {
          System.out.println("输入的银行卡密码不符合要求");
      }
    }
  }
  ```
  
- 替换
  
  ```java
  String str1 = "i am fuyi";
  String[] sArr = str1.split(" ");
  for (String s : sArr) {
      System.out.println(s);
  }

  System.out.println("------------匹配替换----------");

  //将出现的替换字符串全部转换
  String str2 = "i am handsome boy";
  String replace = str2.replace("boy", "girl");
  System.out.println(replace);

  System.out.println("-------------replaceFirst()-------");
  String str3 = "ajdfjaljsldjfljsljfdl";
  String str4 = str3.replaceFirst("j", "4");
  System.out.println(str4);
  String str5 = str3.replaceAll("j", "4");
  System.out.println(str5);
  ```