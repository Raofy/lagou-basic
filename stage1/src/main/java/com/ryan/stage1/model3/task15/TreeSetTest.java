package com.ryan.stage1.model3.task15;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {



    public static void main(String[] args) {

        //1. 准备一个TreeSet集合
        Set treeSet = new TreeSet();

        treeSet.add("aa");
        treeSet.add("cc");
        treeSet.add("bb");

        //由于TreeSet底层使用的红黑树实现，因此有大小上排序，默认从小到大
        System.out.println(treeSet);      //[aa, bb, cc]


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


    }
}
