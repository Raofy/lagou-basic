package com.ryan.stage1.model3.task14;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        //1. 声明一个List接口类型的引用指向ArrayList类型的对象
        //由源码可得：当new对象时并没有申请数组的内存空间
        List list1 = new ArrayList();


        //2. 向集合中添加元素
        //由源码可得：调用add方法添加元素时会给数组申请长度为10的一维数组
        //扩容机制时原始长度的1.5倍
        list1.add("one");
        System.out.println(list1);
    }
}
