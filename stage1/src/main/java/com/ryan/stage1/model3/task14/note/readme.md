# 第十四章 集合类库

## 14.1 集合的概述（重点）

### 14.1.1 集合的由来

- 记录多个类型不同的对象数据

### 14.1.2 集合的框架结构

- collection集合  基本单位是单个元素

- Map集合         基本单位是单对元素（key-value）

- 结构图

![01 集合框架的两张图](../images/01%20集合框架的两张图.png)

## 14.2 collection集合（重点）

### 14.2.1 基本概念

java.util.Collection接口是List接口、Queue 接口以及Set接口的父接口，因此该接口里定义的方法
既可用于操作List集合，也可用于操作Queue集合和Set集合。

### 14.2.2 常用方法

- 代码demo

  ```java
  //1. 创建一个collection集合
  Collection collection1 = new ArrayList<>();
  System.out.println(collection1);              //[]

  System.out.println("--------------增加元素----------");
  //2. 添加元素
  //添加String类型
  collection1.add(new String("fuyi"));
  System.out.println(collection1);

  //添加基本数据类型
  collection1.add(23);
  System.out.println(collection1);

  //添加自定义类型
  collection1.add(new Student("Sam", 2, "guangzhou"));
  System.out.println(collection1);

  //3. 添加多个元素
  Collection collection2 = new ArrayList<>();
  collection2.add(45);
  collection2.add("Lucy");
  collection1.addAll(collection2);
  System.out.println(collection1);                        //[fuyi, 23, Student{name='Sam', id=2, address='guangzhou'}, 45, Lucy]

  //4. 注意
  collection1.add(collection2);
  System.out.println(collection1);                       //[fuyi, 23, Student{name='Sam', id=2, address='guangzhou'}, 45, Lucy, [45, Lucy]]

  System.out.println("------------collection常用方法----------------");

  //1. contains方法
  boolean contains = collection1.contains(23);
  System.out.println(contains);                          //true

  boolean fuyi = collection1.contains(new String("fuyi"));
  System.out.println(fuyi);                              //true

  //这里打印结果为false，要了解contains方法对于引用类型的判断
  //contains工作原理：Objects.equals(o,e)
  //底层源码
  /**
   *  public boolean contains(Object o) {
   *         return indexOf(o) >= 0;
   *     }
   *  public int indexOf(Object o) {
   *         if (o == null) {
   *             for (int i = 0; i < size; i++)
   *                 if (elementData[i]==null)
   *                     return i;
   *         } else {
   *             for (int i = 0; i < size; i++)
   *                 if (o.equals(elementData[i]))
   *                     return i;
   *         }
   *         return -1;
   *     }
   *
   * public static boolean equals(Object a, Object b) {
   *         return (a == b) || (a != null && a.equals(b));
   *     }
   */
  /**
   * 因为这里使用了多态，该子类是ArrayList的引用，因此这里查看ArrayList的contains方法的代码实现
   * 逻辑，在indexOf方法中，o代表的是传进来的对象，elementData里面存放的是collection中所有元素
   * 可以清楚的看到形参o调用equals方法进行和collection中元素进行比对。所以要实现自定义类的equals
   * 方法。其实最终的工作原理是调用Objects.equals(o,e)方法进行比较
   */
  boolean contains1 = collection1.contains(new Student("Sam", 2, "guangzhou"));
  System.out.println(contains1);                         //false -> true

  //2. containsAll方法，只要需要比较的集合里面有一个元素不包含都会返回false
  System.out.println(collection1);
  System.out.println("是否包含collection2中的所有元素" + collection1.containsAll(collection2));
  collection2.add("noncontain");
  System.out.println("是否包含collection2中的所有元素" + collection1.containsAll(collection2));

  //3. retainAll方法，取两个集合的交集部分，如果返回true，原本的集合内容将会被覆盖
  System.out.println();

  System.out.println(collection1);                  //[fuyi, 23, Student{name='Sam', id=2, address='guangzhou'}, 45, Lucy, [45, Lucy, noncontain]]
  System.out.println(collection2);                  //[45, Lucy, noncontain]

  boolean b = collection1.retainAll(collection1);
  System.out.println(b);                            //false
  System.out.println(collection1);                  //[fuyi, 23, Student{name='Sam', id=2, address='guangzhou'}, 45, Lucy, [45, Lucy, noncontain]]

  boolean b1 = collection1.retainAll(collection2);
  System.out.println(b1);                           //true
  System.out.println(collection1);                  //[45, Lucy]
  
  System.out.println(collection1);
  
  //4. 查看collection1中元素长度
  System.out.println(collection1.size());

  //5. 判断collection1是否为空
  System.out.println(collection1.isEmpty());

  //6. 清空collection1中所有的元素
  //collection1.clear();
  System.out.println(collection1);

  System.out.println("------------集合向数组转换-------");

  //1. collection -> array
  Object[] objects = collection1.toArray();
  for (Object object : objects) {
      System.out.println(object);
  }

  //2. Array -> collection
  Collection collection2 = Arrays.asList(objects);
  System.out.println(collection2);
  ```

## 14.3 Iterator接口
 
 ### 14.3.1 基本概念
 
 Iterator接口主要用于描述迭代器对象，可以遍历Collection集合中的所有元素
 
 Collection接口继承Iterator接口，因此实现Collection接口的实现类都可以使用迭代器对象
 
 ### 14.3.2 常用方法
 
 - 代码demo
 
   ```java
   Collection collection1 = new ArrayList();
   collection1.add(2);
   collection1.add("fjdjsl");
   collection1.add(77485);
   System.out.println(collection1);

   System.out.println("----使用迭代器遍历collection-----");
   Iterator iterator1 = collection1.iterator();
   //1. 判断是否有下一个元素
   System.out.println(iterator1.hasNext());

   //2. 取出一个元素并且指向下一个
   //System.out.println(iterator1.next());

   //3. 删除最后访问的一个元素
   while (iterator1.hasNext()) {
       Object next = iterator1.next();
       //collection1.remove(next);  //Exception in thread "main" java.util.ConcurrentModificationException并发修改异常
       //iterator1.remove();
   }

   System.out.println(collection1);
   ```
 
 ## 14.4 foreach循环（重点）
 
 ### 14.4.1 基本概念
 
 JDK5推出增强型for循环语句，可以应用数组和集合的遍历，是迭代的简化版
 
 ### 14.4.2 格式
 
 ```text
for(元素类型 变量名 : 数组/集合) {
      循环体；
}
```

### 14.4.3 执行流程

不断从数组/集合里面取出元素赋值给变量执行循环体，直至取完所有元素。

- 代码demo

  ```java
  Collection collection1 = new ArrayList();
  collection1.add(2);
  collection1.add("fjdjsl");
  collection1.add(77485);
  System.out.println(collection1);
  
  System.out.println("-----使用foreach方法进行遍历collection------");
  
  for (Object o : collection1) {
     System.out.println(o);
  }

  collection1.forEach(item -> {
     System.out.println(item);
  });
  ```

## 14.5 List集合

### 14.5.1 基本概念

- java.util.List集合是Collection集合的子集合，该集合中允许有重复的元素并且有先后放入次序。

- 该集合的主要实现类有：ArrayList类、LinkedList类、Stack类、Vector类。

- 其中ArrayList类的底层是采用动态数组进行数据管理的，支持下标访问，增删元素不方便。

- 其中LinkedList类的底层是采用双向链表进行数据管理的，访问不方便，增删元素方便。

- 可以认为ArrayList和LinkedList的方法在逻辑上完全一样，只是在性能上有一定的差别，ArrayList更适合于随
机访问而LinkedList更适合于插入和删除；在性能要求不是特别苛刻的情形下可以忽略这个差别。

- 其中Stack类的底层是采用动态数组进行数据管理的，该类主要用于描述一种具有后进先出特征的
数据结构，叫做栈(last in first out LIFO)。

- 其中Vector类的底层是采用动态数组进行数据管理的，该类与ArrayList类相比属于线程安全的
类，效率比较低，以后开发中基本不用。

### 14.5.2 基本方法

```text
void add(int index, E element)                       向集合中指定位置添加元素
boolean addAll(int index, Collection<? extends E> c) 向集合中添加所有元素
E get(int index)                                     从集合中获取指定位置元素
int indexOf(Object o)                                查找参数指定的对象
int lastIndexOf(Object o)                            反向查找参数指定的对象
E set(int index, E element)                          修改指定位置的元素
E remove(int index)                                  删除指定位置的元素
List subList(int fromIndex, int toIndex)             用于获取子List
```

## 14.6 Queue集合

### 14.6.1 基本概念

- java.util.Queue集合是Collection集合的子集合，与List集合属于平级关系。

- 该集合的主要用于描述具有先进先出特征的数据结构，叫做队列(first in first out FIFO)。

- 该集合的主要实现类是LinkedList类，因为该类在增删方面比较有优势。

### 14.6.2 常用方法

boolean offer(E e) 将一个对象添加至队尾，若添加成功则返回true

E poll() 从队首删除并返回一个元素

E peek() 返回队首的元素（但并不删除）