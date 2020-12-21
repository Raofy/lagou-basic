# 第十一章 常用类的概述和使用

## 11.1 常用包

### 11.1.1 包名和名称

- java.lang 包，由虚拟机自动导入
 
- java.util 包，包含集合框架，一些国际化支持类，服务加载程序，属性，随机数生成，字符串解析和扫描类，base64编码和解码，位数组以及几个其他实用程序类。

- java.math 包，提供用于执行任意精度整数算术（BigInteger）和任意精度十进制算术（BigDecimal）的类

- java.nio 定义缓冲区，缓冲区是数据的容器，并提供其他NIO包的概述。

- java.io包， 通过数据流，序列化和文件系统提供系统输入和输出

## 11.2 Object类（重点）

### 11.2.1 基本概述

   Object类是所有类的基类，所有对象和数组都继承实现Object类的方法。
   
   ```java
    public class MyClass{} 
   ```   
   等价于  
   
   ```java
   public class MyClass extends Object {}
   ```

### 11.2.2 equals方法

- public boolean equals​(Object obj)

    返回其他某个对象是否“等于”该对象的比较结果

- 代码测试
  
  创建student类

  ```Java
  public class Student {

    private String name;

    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        //当如果两个对象指向同一个地址引用的时候，一定为true
        if (this == obj) {
            return true;
        }

        //当传入的对象为null时候，一定是为false
        if (obj == null) {
            return false;
        }

        //重写equals方法用来实现两个对象ID的比较
        if (obj instanceof Student) {
            Student flag = (Student) obj;
            return this.id == flag.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getId();
    }
  }
  ```

 测试代码

 ```Java
 //创建两个student对象
  Student student1 = new Student("fuyi", 1000);
  Student student2 = new Student("fuyi", 1000);
  Student student3 = student1;

  System.out.println("-------------------------equals()--------------------------");

  //1. 调用Object类中equals方法
  //2. 通过下面两种方式进行测试Object类的equals方法，用来比较的是两个对象的引用是否相等
  //3. Object类源码层次
  /**
    * public boolean equals(Object obj) {
    *         return (this == obj);
    *     }
   */
  //4. 如果通过equals方法比较两个对象的id是否相等，则需要重写Object基类的equals方法
  System.out.println(student1.equals(student2));       //false -> true
  System.out.println(student1 == student2);            //false
  System.out.println(student3 == student1);            //true
 ```

 内存分析
 
 ![student类内存分析](../images/student类内存分析.png)

### 11.2.3 hashCode方法

- public int hashCode()
  
  返回对象的哈希码值。支持此方法是为了使哈希表（例如HashMap提供的哈希表）提供协助功能。就是在后面集合HashMap存储元素的时候会调用该方法。

- 代码测试

  重写自定义类中的hashCode（）方法
    
    ```java
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }
  
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    ```
  
  运行测试
  
  ```java
  System.out.println("------------------------hashCode()--------------------------");
  
  //1. 调用Object类中的hashCode()方法
  //2. Java官方常规约束，调用equals（）方法比较的结果的相同，那么调用hashCode（）获取两个对象的结果也应该相同，所以我们需要重写基类中的hashCode()方法
  //3. 这里只要求约束为equals比较结果相等的两个对象，调用hashCode方法结果也相等就可以了
  System.out.println(student1.hashCode());            //1300109446  ->  1000
  System.out.println(student2.hashCode());            //1020371697  ->  1000
  ```
  
  
### 11.2.3 toString方法

- public String toString()

    返回对象的字符串表示形式。 通常，toString方法返回一个“以文本形式表示”此对象的字符串。 结果应该是简洁易懂的表示形式，便于人们阅读。 
    建议所有子类都重写此方法。 Object类的toString方法返回一个字符串，该字符串包括该对象是其实例的类的名称，符号字符“ @”以及该对象的
    哈希码的无符号十六进制表示形式。 换句话说，此方法返回的字符串等于：
        getClass().getName() + '@' + Integer.toHexString(hashCode())
    
- 代码测试

  重写Student类中toString()方法
  
  ```java
  @Override
  public String toString() {
      return "Student{" +
              "name='" + name + '\'' +
              ", id=" + id +
              '}';
  }
  ```
  
  运行打印
  
  ```java
  System.out.println("------------------------toString()---------------------------");
  
  //1. 调用Object类中的toString()方法
  //2. 为了返回更有意义的字符串信息需要重写toString()方法
  //3. 直接打印对象和字符串拼接，默认调用toString方法
  System.out.println(student1.toString());           //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
  System.out.println(student2.toString());           //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
  System.out.println(student1);                      //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
  System.out.println(student2);                      //com.ryan.stage1.model3.task11.Student@3e8  ->  Student{name='fuyi', id=1000}
  System.out.println("打印结果：" + student1);        //打印结果：com.ryan.stage1.model3.task11.Student@3e8  ->  打印结果：Student{name='fuyi', id=1000}
  System.out.println("打印结果：" + student2);        //打印结果：com.ryan.stage1.model3.task11.Student@3e8  ->  打印结果：Student{name='fuyi', id=1000}
  ```

### 11.2.4 getClass方法
- public final Class<?> getClass()

  返回此对象的运行时类。返回的Class对象是被表示的类的静态同步方法锁定的对象
  
- 代码demo

  ```java
  System.out.println("------------------------getClass()----------------------------");
  
  //1. 获取该对象的实例，常用于反射机制
  System.out.println(student1.getClass());           //class com.ryan.stage1.model3.task11.Student
  System.out.println(student2.getClass());           //class com.ryan.stage1.model3.task11.Student
  ```
 

### 11.2.5 自动重写equals、hashCode和toString方法
- Idea编辑器快捷键
  
  window：alt + insert快捷键

## 11.3 包装类（熟悉）

- 背景
  
  在 Java 的设计中提倡一种思想，即一切皆对象。但是从数据类型的划分中，我们知道 Java 中的数据类型分为基本数据类型和引用数据类型，
  但是基本数据类型怎么能够称为对象呢？于是 Java 为每种基本数据类型分别设计了对应的类，称之为包装类（Wrapper Classes），也有地方称为外覆类或数据类型类。
  

### 11.3.1 基本概念

Java给每一种基本数据类型进一步封装成了一个类，这个类就叫做包装类。

- 映射关系

    ```text
      byte    ->    Byte
      
      short   ->    Short
      
      int     ->    Integer
      
      long    ->    Long
      
      char    ->    Character
      
      float   ->    Float
      
      double  ->    Double
      
      boolean ->    Boolean
    ```
  
### 11.3.2 装箱与拆箱

基本数据类型转换为包装类的过程称为装箱，例如把 int 包装成 Integer 类的对象(int -> Integer)；

包装类变为基本数据类型的过程称为拆箱，例如把 Integer 类的对象重新简化为 int(Integer -> int)。
  
### 11.3.3 Integer类的构造方式

- 代码demo

  ```java
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
  ```

### 11.3.4 Integer类的装箱和拆箱机制

- 代码demo

  ```java
  System.out.println("-----------------Integer类的装箱和拆箱机制-----------------------------------------------");
  
  //JDK5 新增自动拆装箱机制
  //1. int -> Integer  装箱
  //自动装箱
  Integer integer5 = 100;

  //2. Integer -> int 拆箱
  //自动拆箱
  int i5 = integer5;
  ```
  
- 笔试考点

  ```java
  //3. 笔试考点
  //主要考察自动装箱池机制，JVM自动将-128到127的正数进行提前装箱，当调用到时，直接赋引用地址调用池中的对象，提高效率
  //Double类没有自动装箱池
  Integer integer6 = 127;                                                        //128 -> 127
  Integer integer7 = 127;                                                        //128 -> 127
  Integer integer8 = new Integer(127);                                           //128 -> 127
  Integer integer9 = new Integer(127);                                           //128 -> 127
  System.out.println(integer6 == integer7);                                      //false -> true
  System.out.println(integer6.equals(integer7));                                 //true -> true
  System.out.println(integer8 == integer9);                                      //false -> false
  System.out.println(integer8.equals(integer9));                                 //true -> true
  ```
  
### 11.3.5 Integer、int和String类型之间转换

- 代码demo

  ```java
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
  System.out.println("int -> String ：" + Integer.toString(98));                  //int -> String ：98

  System.out.println("int -> String ：" + Integer.toBinaryString(98));            //int -> String ：1100010
  ```

### 11.3.5 Double类

各个基本数据类型的包装类的方法都大同小异，就不再加以论述了。

- 常用方法

  ```java
  System.out.println("---------------------常用方法------------------------");
  
  //1. 判断是否为非数值
  Double double1 = new Double(187.293847);
  double v = Double.parseDouble("18.983");
  System.out.println("是否为非数值：" + double1.isNaN());               //是否为非数值：false
  System.out.println("是否为非数值：" + Double.isNaN(v));               //是否为非数值：false
  ```

### 11.3.6 Boolean类

- Boolean类的自动装箱和自动拆箱
 
  ```java
  System.out.println("----------------Boolean类的自动装箱和自动拆箱----------------");
  //1. JDK5之前
  //装箱
  Boolean boolean1 = Boolean.valueOf("true");
  System.out.println(boolean1);                           //true
  //拆箱
  boolean b = boolean1.booleanValue();
  System.out.println(b);                                  //true

  //2. JDK5之后
  //自动装箱和自动拆箱
  Boolean boolean2 = false;
  boolean b2 = boolean2;
  System.out.println(b2);                                 //false
  ```

### 11.3.7 wrapper类总结

- 基本类型转换为包装类的方式：调用构造和静态方法；

- 获取包装类中的基本数据类型方式：调用包装类中xxxValue方法即可；

- 字符串转基本数据类型的方式：调用包装类中的parseXxx方法


## 11.4 数学处理类（熟悉）

### 11.4.1 Math类概念

用于提供执行数学运算的方法

### 11.4.2 BigDecimal类

- 背景
  
  通常平时我们使用double和float类型做加减乘除运算的时候不能很精确，BigDecimal类就可以很好的解决这个问题。

- 构造方法

  ```java
  System.out.println("-----------------构造方法--------------------");
  
  BigDecimal bigDecimal1 = new BigDecimal("1.5");
  BigDecimal bigDecimal2 = new BigDecimal("1.25");
  ```
- 常用方法

  ```java
  System.out.println("-----------------常用方法--------------------");
  
  System.out.println("加法运算：" + bigDecimal1.add(bigDecimal2));        //2.75
  System.out.println("减法运算：" + bigDecimal1.subtract(bigDecimal2));   //0.25
  System.out.println("乘法运算：" + bigDecimal1.multiply(bigDecimal2));   //1.875
  System.out.println("除法运算：" + bigDecimal1.divide(bigDecimal2));     //1.2
  ```
  
- 注意事项
  
  ```java
  System.out.println("-----------------注意事项---------------------");
  
  BigDecimal bigDecimal3 = new BigDecimal("1.5");
  BigDecimal bigDecimal4 = new BigDecimal("1.3");
  System.out.println("除不尽小数处理：" + bigDecimal3.divide(bigDecimal4, RoundingMode.HALF_UP)); //1.2
  ```

### 11.4.3 BigInteger类概念

- 背景
 
  有些时候long类型不能表示数可以使用BigInteger类进行，毕竟long类型表示的范围是有限的。
  
- 构造方法

  ```java
  System.out.println("-----------------构造方法--------------------");
  
  BigInteger bigInteger1 = new BigInteger("5");
  BigInteger bigInteger2 = new BigInteger("3");
  ```
  
- 常用方法

  ```java
  System.out.println("-----------------常用方法--------------------");
  
  System.out.println("加法运算：" + bigInteger1.add(bigInteger2));                        //8
  System.out.println("减法运算：" + bigInteger1.subtract(bigInteger2));                   //2
  System.out.println("乘法运算：" + bigInteger1.multiply(bigInteger2));                   //15
  System.out.println("除法运算：" + bigInteger1.divide(bigInteger2));                     //1

  BigInteger[] bigIntegers = bigInteger1.divideAndRemainder(bigInteger2);
  System.out.println("除法运算一次性获取商和小数：");

  for (BigInteger bigInteger : bigIntegers) {
      System.out.println(bigInteger.floatValue());                                       //1.0 2.0
  }
  ```