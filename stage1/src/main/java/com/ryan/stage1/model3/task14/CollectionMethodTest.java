package com.ryan.stage1.model3.task14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionMethodTest {


    public static void main(String[] args) {

        Collection collection1 = new ArrayList();

        collection1.add(1);
        collection1.add(2);
        collection1.add("fuyi");
        collection1.add("jfjj");
        System.out.println(collection1);

        //1. 查看collection1中元素长度
        System.out.println(collection1.size());

        //2. 判断collection1是否为空
        System.out.println(collection1.isEmpty());

        //3. 清空collection1中所有的元素
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
    }
}
