package com.ryan.stage1.model4.task16;

public class ExceptionPreventTest {

    public static void main(String[] args) {

        System.out.println("-------------算术异常------------");
        int a = 8;
        int b = 0;
        if (0 != b) {
            System.out.println(a / b);
        }

        System.out.println("------------下标越界异常--------");
        int[] arr = new int[5];
        int index = 5;
        if (arr.length > 0 && arr.length < 5) {
            System.out.println(arr);
        }

        System.out.println("-------------空指针异常----------");
        String str = null;
        if (null != str) {
            System.out.println(str.length());
        }

        System.out.println("------------类型转换异常---------");
        Object it = new Object();
        if(it instanceof String) {
            String c = (String) it;
        }

        System.out.println("------------数据格式异常---------");
        String numStr = "123r";
        if (numStr.matches("\\d+")) {
            int i = Integer.parseInt(numStr);
            System.out.println(i);
        }
    }
}
