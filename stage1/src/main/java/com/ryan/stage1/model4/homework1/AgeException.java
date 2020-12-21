package com.ryan.stage1.model4.homework1;

/**
 * 自定义异常AgeException，用于判断用户年龄是否符合要求
 */
public class AgeException extends Exception{

    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
