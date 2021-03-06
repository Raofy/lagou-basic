# 第二十章 反射机制

## 20.1 基本概念
通常情况下编写代码都是固定的，无论运行多少次执行的结果也是固定的，在某些特殊场合中编写
代码时不确定要创建什么类型的对象，也不确定要调用什么样的方法，这些都希望通过运行时传递
的参数来决定，该机制叫做动态编程技术，也就是反射机制。
通俗来说，反射机制就是用于动态创建对象并且动态调用方法的机制。
目前主流的框架底层都是采用反射机制实现的。如：
```text
Person p = new Person(); - 表示声明Person类型的引用指向Person类型的对象
p.show(); - 表示调用Person类中的成员方法show
```

## 20.2 Class类

### 20.2.1 基本概念
java.lang.Class类的实例可以用于描述Java应用程序中的类和接口，也就是一种数据类型。
该类没有公共构造方法，该类的实例由Java虚拟机和类加载器自动构造完成，本质上就是加载到内
存中的运行时类。

### 20.2.2 获取Class对象的方式
使用数据类型.class的方式可以获取对应类型的Class对象（掌握）。

使用引用/对象.getClass()的方式可以获取对应类型的Class对象。

使用包装类.TYPE的方式可以获取对应基本数据类型的Class对象。

使用Class.forName()的方式来获取参数指定类型的Class对象（掌握）。

使用类加载器ClassLoader的方式获取指定类型的Class对象。

### 20.2.3 常用的方法（掌握）

|方法声明 | 功能介绍|
|:------ | :------|
|static Class<?> forName(String className) | 用于获取参数指定类型对应的Class对象并返回|
|T newInstance() | 用于创建该Class对象所表示类的新实例|

## 20.3 Constructor类

### 20.3.1 基本概念
java.lang.reflect.Constructor类主要用于描述获取到的构造方法信息

### 20.3.2 Class类的常用方法

|方法声明 | 功能介绍|
|:------ | :------|
|Constructor getConstructor(Class<?>...parameterTypes) | 用于获取此Class对象所表示类型中参数指定的公共构造方法|
|Constructor<?>[] getConstructors() | 用于获取此Class对象所表示类型中所有的公共构造方法|

### 20.3.3 Constructor类的常用方法

|方法声明 | 功能介绍|
|:------ | :------|
|T newInstance(Object...initargs) | 使用此Constructor对象描述的构造方法来构造Class对象代表类型的新实例|
|int getModifiers() | 获取方法的访问修饰符|
|String getName() | 获取方法的名称|
|Class<?>[] getParameterTypes() | 获取方法所有参数的类型|

## 20.4 Field类
### 20.4.1 基本概念
java.lang.reflect.Field类主要用于描述获取到的单个成员变量信息。

### 20.4.2 Class类的常用方法

|方法声明 | 功能介绍|
|:------ | :------|
|Field getDeclaredField(String name) | 用于获取此Class对象所表示类中参数指定的单个成员变量信息|
|Field[] getDeclaredFields() | 用于获取此Class对象所表示类中所有成员变量信息|

### 20.4.3 Field类的常用方法

|方法声明 | 功能介绍|
|:------ | :------|
|Object get(Object obj) | 获取参数对象obj中此Field对象所表示成员变量的数值|
|void set(Object obj, Object value) | 将参数对象obj中此Field对象表示成员变量的数值修改为参数value的数值|
|void setAccessible(boolean flag) 当实参传递true时，则反射对象在使用时应该取消 Java 语言访问检查|
|int getModifiers() | 获取成员变量的访问修饰符|
|Class<?> getType() | 获取成员变量的数据类型|
|String getName() | 获取成员变量的名称|

## 20.5 Method类

### 20.5.1 基本概念

java.lang.reflect.Method类主要用于描述获取到的单个成员方法信息。

### 20.5.2 Class类的常用方法

|方法声明 | 功能介绍|
|:------ | :------|
|Method getMethod(String name,Class<?>... parameterTypes) | 用于获取该Class对象表示类中名字为name参数为parameterTypes的指定公共成员方法|
|Method[] getMethods() | 用于获取该Class对象表示类中所有公共成员方法|
### 20.5.3 Method类的常用方法

|方法声明 | 功能介绍|
|:------ | :------|
|Object invoke(Object obj,Object... args) | 使用对象obj来调用此Method对象所表示的成员方法，实参传递args|
|int getModifiers() | 获取方法的访问修饰符|
|Class<?> getReturnType() | 获取方法的返回值类型|
|String getName() | 获取方法的名称|
|Class<?>[] getParameterTypes() | 获取方法所有参数的类型|
|Class<?>[] getExceptionTypes() | 获取方法的异常信息|

## 20.6 获取其它结构信息

|方法声明 | 功能介绍|
|:------ | :------|
|Package getPackage() | 获取所在的包信息|
|Class<? super T> getSuperclass() | 获取继承的父类信息|
|Class<?>[] getInterfaces() | 获取实现的所有接口|
|Annotation[] getAnnotations() | 获取注解信息|
|Type[] getGenericInterfaces() | 获取泛型信息|
