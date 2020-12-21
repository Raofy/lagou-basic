package com.ryan.stage1.model3.task11;

public class IntegerTest {

    public static void main(String[] args) {


        System.out.println("-------------------Integer类常见属性成员---------------------");

        System.out.println("占用字节数：" + Integer.BYTES);                              //占用字节数：4
        System.out.println("最大表示正数：" + Integer.MAX_VALUE);                        //最大表示正数：2147483647
        System.out.println("最大表示负数：" + Integer.MIN_VALUE);                        //最大表示负数：-2147483648
        System.out.println("用于表示二进制补码二进制形式的int值的位数：" + Integer.SIZE);   //用于表示二进制补码二进制形式的int值的位数：32
        System.out.println("表示原始类型int的Class实例：" + Integer.TYPE);                //表示原始类型int的Class实例：int


        System.out.println("-------------------Integer构造方法-----------------------");

        //1. Integer(int i)构造
        //2. Integer(String s) 构造
        //3. 上述两种构造在JDK9已经被遗弃，提供了静态工厂构造方法valueOf(int i)和valueOf(String s)
        Integer integer1 = new Integer(123456);
        Integer integer2 = new Integer("789");
        Integer integer3 = Integer.valueOf(123456);
        Integer integer4 = Integer.valueOf("789");


        System.out.println("------------------Integer、int和String类型之间转换-------------------------------");

        //1. Integer和int之间转换，int转成Integer使用构造方法进行转换
        int intValue = integer1.intValue();
        System.out.println("Integer -> int ：" + intValue);                             //Integer -> int ：123456

        //2. Integer -> String
        String s = integer2.toString();
        System.out.println("Integer -> String ：" + s);                                 //Integer -> String ：789

        //3. String -> int
        int i = Integer.parseInt("345");
        System.out.println("String -> int ：" + i);                                     //String -> int ：345

        //4. int -> String
        System.out.println("int -> String ：" + Integer.toString(98));               //int -> String ：98

        System.out.println("int -> String ：" + Integer.toBinaryString(98));         //int -> String ：1100010


        System.out.println("-----------------Integer类的装箱和拆箱机制-----------------------------------------------");

        //JDK5 新增自动拆装箱机制
        //1. int -> Integer  装箱
        //自动装箱
        Integer integer5 = 100;

        //2. Integer -> int 拆箱
        //自动拆箱
        int i5 = integer5;

        //3. 笔试考点
        //主要考察自动装箱池机制，JVM自动将-128到127的正数进行提前装箱，当调用到时，直接赋引用地址调用池中的对象，提高效率
        //Double类没有自动装箱池
        Integer integer6 = 127;                                                        //128 -> 127
        Integer integer7 = 127;                                                        //128 -> 127
        Integer integer8 = new Integer(127);                                     //128 -> 127
        Integer integer9 = new Integer(127);                                     //128 -> 127
        System.out.println(integer6 == integer7);                                      //false -> true
        System.out.println(integer6.equals(integer7));                                 //true -> true
        System.out.println(integer8 == integer9);                                      //false -> false
        System.out.println(integer8.equals(integer9));                                 //true -> true


        System.out.println("---------------------常用方法------------------------------------");

        //1. 十进制数值打印
        System.out.println("十进制：" + Integer.toString(10));                        //十进制：10

        //2. 二进制数值
        System.out.println("二进制：" + Integer.toBinaryString(10));                  //二进制：1010

        //3. 八进制数值
        System.out.println("八进制：" + Integer.toOctalString(10));                   //八进制：12

        //4. 十六进制
        System.out.println("十六进制：" + Integer.toHexString(10));                    //十六进制：a

    }



}
