package com.ryan.stage1.model3.task15;

import java.util.*;

public class HashSetTest {

    public static void main(String[] args) {

        //1. 使用Set的引用指向子类HashSet的对象
        Set hashSet1 = new HashSet();
        System.out.println(hashSet1);        //[]

        hashSet1.add("fuyi");
        hashSet1.add("Lucy");
        hashSet1.add("Sam");
        System.out.println(hashSet1);        //[Lucy, Sam, fuyi]

        //2. 使用Set的引用指向子类LinkedHashSet的对象
        Set linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("fuyi");
        linkedHashSet.add("Lucy");
        linkedHashSet.add("Sam");
        System.out.println(linkedHashSet);   //[fuyi, Lucy, Sam]
    }
}
