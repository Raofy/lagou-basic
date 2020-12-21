# 第十五章 集合类库

## 15.1 泛型机制

### 15.1.1 基本概念

- 背景：由于集合中增加一个元素，集合都是以Object类型进行存储的，当取出元素的时候放回的数据
类型也是Object类型，如果要想得到某个具体的类型必须进行类型强转，而强转这个过程很容易发生类型
转化异常。

- 解决方案：为了解决上述问题，JDK5提出了泛型的机制，也就是在创建集合的时候指定一个泛型类型，
类型取决于存储数据的时候，是什么类型就是什么类型。如果放入的是其他类型编译的时候就会出错，
通过这个参数限制操作的数据类型，从而保证类型转换的绝对安全。

- **泛型机制在编译时期区分类型，而在运行的时候是不区分类型的**

### 15.1.2 底层原理

- 本质：参数化类型，也就是将数据类型作为参数进行传递

- 叙述：比如很多List<E>、ArrayList<E>等集合来说，<E>相当于一个占位符，一个形式参数。就好比一个方法体里面需要
传递参数，只不过这里的传递的参数有点特别，传的是数据类型。

### 15.1.3 自定义泛型接口

- 自定义泛型接口与普通接口的区别在于接口名后面是否有<E,T...>

### 15.1.4 自定义泛型类

同样的道理自定义泛型类和普通类的区别也是在于类名后面是否有<E,T....>

- 语法格式

```text
public class class_name<data_type1,data_type2,…>{}
```

- 泛型类的继承

代码分析

```text
package com.ryan.stage1.model3.task15;

public class SubStudent extends Student{        //子类不保留父类的泛型，此时父类中的泛型被解析为Object类型
public class SubStudent extends Student<String> { //子类不保留父类的泛型，指定父类中的泛型为String类型
public class SubStudent<T> extends Student<T> {   //子类保留了父类的泛型并且父类中的泛型字段的类型取决于子类传入的类型参数
public class SubStudent<T, E> extends Student<T> {  //子类保留了父类的泛型并且增加了一个新的泛型
}
```

测试代码

```text
package com.ryan.stage1.model3.task15;

public class SubStudentTest {

    public static void main(String[] args) {

        System.out.println("---------不保留泛型且不指定类型---------");
        SubStudent subStudent1 = new SubStudent();
        subStudent1.setId(1);
        subStudent1.setName("Sam");
        subStudent1.setGender("boy");
        Object gender1 = subStudent1.getGender();
        System.out.println(subStudent1);
        System.out.println(gender1);

        System.out.println("---------不保留泛型且指定了类型---------");

        SubStudent subStudent2 = new SubStudent();
        subStudent2.setId(2);
        subStudent2.setName("Lucy");
        subStudent2.setGender("girl");
        System.out.println(subStudent2);
        String gender2 = subStudent2.getGender();
        System.out.println(gender2);

        System.out.println("---------保留泛型且由子类决定类型---------");

        SubStudent<Boolean> subStudent3 = new SubStudent();
        subStudent3.setId(3);
        subStudent3.setName("KangKang");
        subStudent3.setGender(true);
        System.out.println(subStudent3);
        Boolean gender3 = subStudent3.getGender();
        System.out.println(gender3);

        System.out.println("---------保留泛型且由子类增加类型---------");

        SubStudent<Boolean, Double> subStudent4 = new SubStudent();
        subStudent4.setId(4);
        subStudent4.setName("John");
        subStudent4.setGender(true);
        System.out.println(subStudent4);
        Boolean gender4 = subStudent4.getGender();
        System.out.println(gender4);
    }
}
```

### 15.1.5 自定义泛型方法

- 概念：类型参数化的方法称为泛型方法；是否拥有泛型方法，与其所在的类是不是泛型没有关系。

- 语法格式

```text
[访问权限修饰符][static][final]<类型参数列表>返回值类型方法名([形式参数列表])
```

- 代码分析

  ```java
  //自定义泛型方法
  public static <T> void genericPrint(T[] arr) {
      for (T t : arr) {
          System.out.println(t);
      }
  }
  ```
  
- 代码测试
  
  ```java
  System.out.println("---------自定义泛型方法---------");
  
  Integer[] arr = new Integer[] {1, 2, 5, 9, 198};
  Student.genericPrint(arr);
  ```

- 运行结果

  ```text
  ---------自定义泛型方法---------
  1
  2
  5
  9
  198
  ```
 
 ### 15.1.6 通配符的使用
 
 - 背景：在平时我们经常会使用到类的继承，而父类和子类分别作为泛型传入所得到的两个集合是不存在继承关系的。
 
 - 代码分析
   
   Person类
   ```java
   public class Person {}
   ```
   
   Teacher类
   ```java
   import com.ryan.stage1.model3.task15.Person;
   public class Teacher extends Person {}
   ```
 - 测试代码
 
   ```java
   System.out.println("---------验证父子类泛型集合是否存在继承关系--------");
   
   List<Person> list1 = new LinkedList<>();
   List<Teacher> list2 = new LinkedList<>();

   //编译报错
   //list1 = list2;   //Error: 不兼容类型
   ```
   
 - 解决方案：对于上述出现的问题，Java提供了通配符去解决
 
 在 Java 中默认可以使用任何类型来实例化一个泛型类对象。当然也可以对泛型类实例的类型进行限制，语法格式如下：
 
 ```text
//限制泛型类型T必须是实现某个接口类的
class 类名称<T extends anyClass>
 ```

Java 中的泛型还支持使用类型通配符，它的作用是在创建一个泛型类对象时限制这个泛型类的类型必须实现或继承某个接口或类。
语法格式
```text
泛型类名称<? extends List>a = null;
或者是
泛型类名称<? super List>a = null;
```
 
  - 代码分析
    
    ```java
    System.out.println("---------通配符解决方案-------");
    
    //1. 使用通配符作为泛型的公共父类
    List<?> list3 = new LinkedList<>();
    List<?> list4 = new LinkedList<>();
    list1.add(new Person());
    list2.add(new Teacher());

    list3 = list1;
    list4 = list2;

    //编译错误，使用？通配符是不能进行增加元素的
    //list3.add(new Person());
    System.out.println(list3.get(0)); //com.ryan.stage1.model3.task15.Person@4d7e1886

    //2. 使用有限制的通配符     上限是Person类
    List<? extends Person> list5 = new LinkedList<>();

    //编译错误，还是不可以增加元素
    //list5.add(new Person());
    //list5.add(new Teacher());
    list5 = list2;
    Person person = list5.get(0);
    System.out.println(person);      //com.ryan.stage1.model3.task15.Teacher@47089e5f

    //3. 使用<? super Person>，下限时Person类
    List<? super Person> list6 = new LinkedList<>();
    list6.add(new Person());
    System.out.println(list6);       //[com.ryan.stage1.model3.task15.Person@4f47d241]
    ```
    
    
## 15.2 Set集合（熟悉）

### 15.2.1 概念

- 放入元素没有先后次序，不可重复

- 实现类：HashSet、TreeSet和LinkedHashSet

- HashSet底层是由哈希表进行管理

- TreeSet底层是由红黑树管理实现

- LinkedHashSet是在HashSet的基础上使用双向链表进行维护，有顺序的取放数据。
  
### 15.2.2 HashSet和LinkedHashSet的使用

### 15.2.3 TreeSet集合

- 二叉树主要指每个节点最多只有两个子节点的树形结构。

- 满足以下3个特征的二叉树叫做有序二叉树。
  
  a.左子树中的任意节点元素都小于根节点元素值；
 
  b.右子树中的任意节点元素都大于根节点元素值；
 
  c.左子树和右子树的内部也遵守上述规则；

- 由于TreeSet集合的底层采用红黑树进行数据的管理，当有新元素插入到TreeSet集合时，需要使
用新元素与集合中已有的元素依次比较来确定新元素的合理位置。
- 比较元素大小的规则有两种方式：

  使用元素的自然排序规则进行比较并排序，让元素类型实现java.lang.Comparable接口；

  使用比较器规则进行比较并排序，构造TreeSet集合时传入java.util.Comparator接口；

  自然排序的规则比较单一，而比较器的规则比较多元化，而且比较器优先于自然排序；

- 自然排序：TreeSet 类同时实现了 Set 接口和 SortedSet 接口。SortedSet 接口是 Set 接口的子接口，可以实现对集合进行自然排序，因此使用 TreeSet 类实现的 Set 接口默认情况下是自然排序的，这里的自然排序指的是升序排序。

代码分析

  ```java
  //1. 准备一个TreeSet集合
  Set treeSet = new TreeSet();

  treeSet.add("aa");
  treeSet.add("cc");
  treeSet.add("bb");

  //由于TreeSet底层使用的红黑树实现，因此有大小上排序，默认从小到大
  System.out.println(treeSet);      //[aa, bb, cc]
  ```
- 自定义排序：TreeSet 只能对实现了 Comparable 接口的类对象进行排序，因为 Comparable 接口中有一个 compareTo(Object o) 方法用于比较两个对象的大小。有的时候需要对自定义的类进行排序和存储，所以要实现

代码分析

  ```java
  //2. 使用Set的引用指向TreeSet的对象
  Set<School> schoolSet = new TreeSet<>();
  /**
   * 如果指定的类型没有事项Comparable接口，打印输出会抛出下面的异常，这是因为使用TreeSet集合进行
   * 存储数据，底层红黑树需要对两个对象进行比较存入，所以有两种解决方案：
   * 第一：就是School类实现java.java.lang.Comparable接口
   * 第二：就是通过构造方法进行TreeSet​(Comparator<? super E> comparator)实现比较
   * throws:Exception in thread "main" java.lang.ClassCastException: com.ryan.stage1.model3.task15.School cannot be cast to java.lang.Comparable
   */

  //1. School类实现java.java.lang.Comparable接口
  schoolSet.add(new School("zhaoqing", 20));
  schoolSet.add(new School("guangzhou", 2));

  System.out.println(schoolSet);                         //[School{name='guangzhou', rank=2}, School{name='zhaoqing', rank=20}]

  //2. TreeSet​(Comparator<? super E> comparator)实现比较
  Comparator<School> schoolComparable = new Comparator<School>() {
      @Override
      public int compare(School o1, School o2) {
          return o2.getName().compareTo(o1.getName());
      }
  };

  //JDK8之后的lambda表达式(参数列表) -> {方法体}
  Comparator<School> schoolComparable2 = (School o1, School o2) -> {
      return o2.getName().compareTo(o1.getName());
  };

  Set<School> schoolSet1 = new TreeSet<>(schoolComparable);
  schoolSet1.add(new School("zhaoqing", 20));
  schoolSet1.add(new School("guangzhou", 2));
  System.out.println(schoolSet1);                        //[School{name='zhaoqing', rank=20}, School{name='guangzhou', rank=2}]

  //直接匿名内部类
  Set schoolSet3 = new TreeSet<>((School o1, School o2) -> {
      return o2.getName().compareTo(o1.getName());
  });
  schoolSet3.add(new School("zhaoqing", 20));
  schoolSet3.add(new School("guangzhou", 2));
  System.out.println(schoolSet3);                        //[School{name='zhaoqing', rank=20}, School{name='guangzhou', rank=2}]
  ```

## 15.3 Map集合


### 15.3.1 基本概念

- java.util.Map<K,V>集合中存取元素的基本单位是：单对元素，其中类型参数如下：

  K - 此映射所维护的键(Key)的类型，相当于目录。
  
  V - 映射值(Value)的类型，相当于内容。
  
- 该集合中key是不允许重复的，而且一个key只能对应一个value。

- 该集合的主要实现类有：HashMap类、TreeMap类、LinkedHashMap类、Hashtable类、Properties类。

    其中HashMap类的底层是采用哈希表进行数据管理的。
    
    其中TreeMap类的底层是采用红黑树进行数据管理的。
    
    其中LinkedHashMap类与HashMap类的不同之处在于内部维护了一个双向链表，链表中记录了
    元素的迭代顺序，也就是元素插入集合中的先后顺序，因此便于迭代。
    
    其中Hashtable类是古老的Map实现类，与HashMap类相比属于线程安全的类，且不允许null作 为key或者value的数值。
    
    其中Properties类是Hashtable类的子类，该对象用于处理属性文件，key和value都是String类
    型的。
    
- Map集合是面向查询优化的数据结构, 在大数据量情况下有着优良的查询性能。经常用于根据key检索value的业务场景。

### 15.3.2 常用方法

 ```text
 V put(K key, V value)                将Key-Value对存入Map，若集合中已经包含该Key，则替换该Key所对应的Value，返回值为该Key原来所对应的Value，若没有则返回null
 V get(Object key)                    返回与参数Key所对应的Value对象，如果不存在则返回null
 boolean containsKey(Object key);     判断集合中是否包含指定的Key
 boolean containsValue (Object value);判断集合中是否包含指定的Value
 V remove(Object key)                 根据参数指定的key进行删除
 Set keySet()                         返回此映射中包含的键的Set视图
 Collection values()                  返回此映射中包含的值的Set视图
 Set<Map.Entry<K,V>> entrySet()       返回此映射中包含的映射的Set视图
 ```

### 15.3.3 HashMap存储原理

- 使用元素的key调用hashCode方法获取对应的哈希码值，再由某种哈希算法计算在数组中的索引位置。

- 若该位置没有元素，则将该键值对直接放入即可。

- 若该位置有元素，则使用key与已有元素依次比较哈希值，若哈希值不相同，则将该元素直接放入。

- 若key与已有元素的哈希值相同，则使用key调用equals方法与已有元素依次比较。

- 若相等则将对应的value修改，否则将键值对直接放入即可。

### 15.3.4 HashMap常量

- DEFAULT_INITIAL_CAPACITY : HashMap的默认容量是16。

- DEFAULT_LOAD_FACTOR：HashMap的默认加载因子是0.75。

- threshold：扩容的临界值，该数值为：容量*填充因子，也就是12。

- TREEIFY_THRESHOLD：若Bucket中链表长度大于该默认值则转化为红黑树存储，该数值是8。

- MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量，该数值是64。

## 15.4 Collection类

### 15.4.1 基本概念

java.util.Collections类主要提供了对集合操作或者返回集合的静态方法。

### 15.4.2 常用方法

```text
static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)  根据元素的自然顺序返回给定集合的最大元素

static T max(Collection<? extends T> coll, Comparator<? super T> comp)                 根据指定比较器引发的顺序返回给定集合的最大元素

static <T extends Object & Comparable<?super T>> T min(Collection<? extends T> coll)   根据元素的自然顺序返回给定集合的最小元素

static T min(Collection<? extends T> coll, Comparator<? super T> comp)                 根据指定比较器引发的顺序返回给定集合的最小元素

static void copy(List<? super T> dest, List<? extends T> src)                          将一个列表中的所有元素复制到另一个列表中

static void reverse(List<?> list)                                                      反转指定列表中元素的顺序

static void shuffle(List<?> list)                                                      使用默认的随机源随机置换指定的列表

static <T extends Comparable<? super T>> void sort(List list)                          根据其元素的自然顺序将指定列表按升序排序

static void sort(List list, Comparator<? super T> c)                                   根据指定比较器指定的顺序对指定列表进行排序

static void swap(List<?> list, int i, int j)                                           交换指定列表中指定位置的元素
```

- 代码demo

  ```java
  List<Integer> integers = Arrays.asList(new Integer[]{23, 45, 67, 89, 198, 54, 24});
  
  //1. 获取集合中最值
  Integer max = Collections.max(integers);
  System.out.println(max);
  System.out.println(Collections.min(integers));

  //2. 将集合进行排序
  Collections.sort(integers);
  System.out.println(integers);

  //3. 将集合进行翻转
  Collections.reverse(integers);
  System.out.println(integers);

  //4. 随机置换
  Collections.shuffle(integers);
  System.out.println(integers);

  //5. 交换元素（首尾两个位置元素交换）
  Collections.swap(integers, 0, integers.size() - 1);
  System.out.println(integers);

  //6. 集合间进行拷贝
  List<Integer> copyList = Arrays.asList(new Integer[10]);
  Collections.copy(copyList, integers);
  System.out.println(copyList);
  ```