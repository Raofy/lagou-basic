package com.ryan.stage1.model3.homework1;

public class homework1 {

    /**
     * 匹配数字正则表达式
     */
    private final static String NUM_REG = "[0-9]";

    /**
     * 匹配大写字母正则表达式
     */
    private final static String UPPER_CHAR_REG = "[A-Z]";

    /**
     * 匹配小写字母正则表达式
     */
    private final static String LOWER_CHAR_REG = "[a-z]";

    /**
     * 统计数字
     */
    private static long NUM_COUNT = 0;

    /**
     * 统计大写字母
     */
    private static long UPPER_CHAR_COUNT = 0;

    /**
     * 统计小写字母
     */
    private static long LOWER_CHAR_COUNT = 0;

    /**
     * 统计其他字符
     */
    private static long OTHER_CHAR_COUNT = 0;

    //存储匹配后的字符
    public static StringBuffer NUM_BUFFER = new StringBuffer();        //数字
    public static StringBuffer UPPER_CHAR_BUFFER = new StringBuffer(); //大写字母
    public static StringBuffer LOWER_CHAR_BUFFER = new StringBuffer(); //小写字母
    public static StringBuffer OTHER_CHAR_BUFFER = new StringBuffer(); //其他字符

    /**
     * 统计字符个数
     *
     * @param args
     */
    public static void main(String[] args) {

        String str = "ABCD123!@#$%ab";

        //1. 循环遍历字符串
        for (int i = 0; i < str.length(); i++) {

            //2. char -> String
            String item = String.valueOf(str.charAt(i));

            //3. 正则匹配
            if (item.matches(NUM_REG)) {                    //匹配数字
                NUM_COUNT++;
                NUM_BUFFER.append(item);
            } else if (item.matches(UPPER_CHAR_REG)) {      //匹配大写字母
                UPPER_CHAR_COUNT++;
                UPPER_CHAR_BUFFER.append(item);
            } else if (item.matches(LOWER_CHAR_REG)) {      //匹配小写字母
                LOWER_CHAR_COUNT++;
                LOWER_CHAR_BUFFER.append(item);
            } else {                                        //出上面外其他字符
                OTHER_CHAR_COUNT++;
                OTHER_CHAR_BUFFER.append(item);
            }
        }


        //4. 打印
        System.out.println("发现数字：" + NUM_BUFFER.toString() + ";" + "目前数字个数有：" + NUM_COUNT);
        System.out.println("发现大写字母：" + UPPER_CHAR_BUFFER.toString() + ";" + "目前大写字母个数有：" + UPPER_CHAR_COUNT);
        System.out.println("发现小写字母：" + LOWER_CHAR_BUFFER.toString() + ";" + "目前小写字母个数有：" + LOWER_CHAR_COUNT);
        System.out.println("发现其他字符：" + OTHER_CHAR_BUFFER.toString() + ";" + "目前其他字符个数有：" + OTHER_CHAR_COUNT);
    }
}
