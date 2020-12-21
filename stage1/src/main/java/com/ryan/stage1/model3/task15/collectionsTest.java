package com.ryan.stage1.model3.task15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class collectionsTest {

    public static void main(String[] args) {

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
    }
}
