package com.ryan.stage1.model4.task16;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SubExceptionMethodOverrideTest extends ExceptionMethodOverrideTest {


    /**
     * 可以不抛出异常
     */
    @Override
    public void test1(){

    }

    /**
     * 抛出小的异常
     *
     * @throws FileNotFoundException
     */
    @Override
    public void test2() throws FileNotFoundException {

    }

    /**
     * 抛出比父类方法大或者同层次的异常，编译不通过
     *
     * @throws IOException
     */
//    @Override
//    public void test3() throws Exception {
//
//    }
}
