package com.ryan.stage2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementTest {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String name = sc.nextLine();
        System.out.println("请输入密码: ");
        String pass = sc.nextLine();
        System.out.println(pass);
        //1.获取 PrepareStatement 预编译对象
        //1.1 编写SQL 使用 ? 占位符方式
        String sql = "select * from jdbc_user where username = ? and password = ?";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //1.2 设置占位符参数
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pass);
        //2. 执行查询 处理结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("登录成功! 欢迎您: " + name);
        }else{
            System.out.println("登录失败!");
        }

        //3.释放资源
        JDBCUtil.close(connection,preparedStatement,resultSet);


    }
}
