package com.ryan.stage1.model3.task14;




import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {

    public static void main(String[] args) {

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
    }
}
