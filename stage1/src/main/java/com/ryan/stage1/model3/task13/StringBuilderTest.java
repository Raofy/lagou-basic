package com.ryan.stage1.model3.task13;

public class StringBuilderTest {

    public static void main(String[] args) {

        System.out.println("------StringBuilder类方法-------");

        //1. 无参构造
        StringBuilder stringBuilder1 = new StringBuilder();
        System.out.println("stringBuilder1 = " + stringBuilder1);
        System.out.println("容量是：" + stringBuilder1.capacity());
        System.out.println("长度是：" + stringBuilder1.length());

        //2. 指定容量构造
        System.out.println("----------指定容量构造------------");
        StringBuilder stringBuilder2 = new StringBuilder(20);
        System.out.println("stringBuilder2 = " + stringBuilder2);
        System.out.println("容量是：" + stringBuilder2.capacity());
        System.out.println("长度是：" + stringBuilder2.length());

        //3. 指定字符串构造
        System.out.println("---------- 指定字符串构造------------");
        StringBuilder stringBuilder3 = new StringBuilder("jlsjljg");
        System.out.println("stringBuilder3 = " + stringBuilder3);
        System.out.println("容量是：" + stringBuilder3.capacity());
        System.out.println("长度是：" + stringBuilder3.length());

        //4. 插入和追加字符串内容
        System.out.println("---------- 插入和追加字符串内容------------");
        StringBuilder stringBuilder4 = stringBuilder3.insert(0, "fuyi");
        System.out.println("stringBuilder4 = " + stringBuilder4);
        System.out.println(stringBuilder3 == stringBuilder4);
        //末尾追加字符串
        stringBuilder4.append("china");
        System.out.println(stringBuilder3);

        //5. 删除字符串
        System.out.println("----------删除字符串 ------------");
        //每次删除一个字符，后面的字符会在往前补位，下标会发生变化
        stringBuilder3.deleteCharAt(0);
        System.out.println(stringBuilder3);
        //删除下标为0-3的字符
        stringBuilder3.delete(0, 3);
        System.out.println(stringBuilder3);

        //6. 替换内容和字符串翻转
        System.out.println("---------替换内容和字符串翻转--------");
        stringBuilder3.setCharAt(0, 'F');
        System.out.println(stringBuilder3);
        // 修改字符串
        stringBuilder3.replace(0, 3, "fu");
        System.out.println(stringBuilder3);
        // 翻转字符串
        stringBuilder3.reverse();
        System.out.println(stringBuilder3);


        //7. StringBuilder <-> String
        String s = stringBuilder3.toString();
        StringBuilder stringBuilder = new StringBuilder(s);

        StringBuilder stringBuilder5 = new StringBuilder("1");
        StringBuilder stringBuilder6 = new StringBuilder("2");
        StringBuilder append = stringBuilder5.append(stringBuilder6);
        stringBuilder6 = stringBuilder5;
        System.out.println(stringBuilder5);
        System.out.println(stringBuilder6);

    }
}
