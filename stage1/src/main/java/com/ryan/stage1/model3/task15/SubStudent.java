package com.ryan.stage1.model3.task15;

//public class SubStudent extends Student{        //子类不保留父类的泛型，此时父类中的泛型被解析为Object类型
//public class SubStudent extends Student<String> { //子类不保留父类的泛型，指定父类中的泛型为String类型
//public class SubStudent<T> extends Student<T> {   //子类保留了父类的泛型并且父类中的泛型字段的类型取决于子类传入的类型参数
public class SubStudent<T, E> extends Student<T> {  //子类保留了父类的泛型并且增加了一个新的泛型
}
