package com.ryan.stage2;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动(可省略)
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://localhost:3306/JDBC?characterEncoding=UTF-8";
        Connection connection = DriverManager.getConnection(url);
        System.out.println(connection);

        // 3. 获取statement对象
        Statement statement = connection.createStatement();

        // 4. 执行sql语句
        String sql = "select * from JDBC";
        ResultSet resultSet = statement.executeQuery(sql);

        // 4.1 判断是否有下一个元素
        boolean next = resultSet.next();

        // 4.2 获取列名为id的值
        int id = resultSet.getInt("id");
        System.out.println(id);

        // 4.3 使用循环的方式遍历
        while(resultSet.next()){
            //获取id
            int ids = resultSet.getInt("id");

            //获取姓名
            String username = resultSet.getString("username");

            //获取生日
            Date birthday = resultSet.getDate("birthday");
            System.out.println(ids + " = " +username + " : " + birthday);
        }

        // 关闭资源
        resultSet.close();
        statement.close();
        connection.close();


    }
}
