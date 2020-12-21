package com.ryan.stage1.model4.task16;

public class AgeException extends Exception{

    /**
     * 自定义异常AgeException，用于判断用户年龄是否符合要求
     */
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
