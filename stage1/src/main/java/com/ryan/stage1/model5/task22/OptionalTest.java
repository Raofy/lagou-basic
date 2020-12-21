package com.ryan.stage1.model5.task22;

import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {

    public static void main(String[] args) {

        System.out.println("-------------------常规的判断字符串是否为空的方式--------------");
        String str = null;
        if (null != str) {
            System.out.println("字符串长度为：" + str.length());
        } else {
            System.out.println("字符串长度为：" + 0);
        }

        System.out.println("--------------------使用Optional类容器进行判断-----------------");
        /**
         * 1. 将str撞到Optional对象中去
         */
        Optional<String> stringOptional = Optional.ofNullable(str);

        /**
         * 2. 建立映射关系 使用字符串的长度和字符串建立映射关系
         */
        Optional<Integer> length = stringOptional.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.println("length的长度为：" + length);

        /**
         * 3. 使用lambda表达式
         */
        Optional<Integer> length2 = stringOptional.map(s -> s.length());
        System.out.println("length2的长度为：" + length2);

        Optional<Integer> length3 = stringOptional.map(String::length);
        System.out.println("length3的长度为：" + length3);

        /**
         * 4. 若该值存在就返回，否则返回other的数值(此处other为4)
         *
         */
        Integer integer = length3.orElse(4);
        System.out.println(integer);


    }
}
