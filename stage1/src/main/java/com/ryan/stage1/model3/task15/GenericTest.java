package com.ryan.stage1.model3.task15;

import java.util.LinkedList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {


        System.out.println("---------验证父子类泛型集合是否存在继承关系--------");

        List<Person> list1 = new LinkedList<>();
        List<Teacher> list2 = new LinkedList<>();

        //编译报错
        //list1 = list2;   //Error: 不兼容类型


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
    }
}
