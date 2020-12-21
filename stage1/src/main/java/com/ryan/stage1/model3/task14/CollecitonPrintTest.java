package com.ryan.stage1.model3.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollecitonPrintTest {

    public static void main(String[] args) {


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


        System.out.println("-----使用foreach方法进行遍历collection------");

        for (Object o : collection1) {
            System.out.println(o);
        }

        collection1.forEach(item -> {
            System.out.println(item);
        });
    }
}
