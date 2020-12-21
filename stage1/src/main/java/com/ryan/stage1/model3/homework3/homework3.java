package com.ryan.stage1.model3.homework3;

import java.util.HashMap;
import java.util.Map;

public class homework3 {

    public static void main(String[] args) {

        //创建一个HashMap，key值为分割后的子串，value用以统计数量
        HashMap<String, Integer> result = new HashMap<>();

        String str = "123,456,789,123,456";

        //通过“，”作为分隔符分割字符串
        String[] split = str.split(",");

        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            //判断map集合里面是否已经存在该key
            if (result.containsKey(item)) {
                int intValue = result.get(item).intValue();
                intValue++;
                result.put(item, intValue);
                continue;
            }
            result.put(item, 1);

        }

        //打印结果
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + "出现了" + entry.getValue().intValue() + "次");
        }
    }
}
