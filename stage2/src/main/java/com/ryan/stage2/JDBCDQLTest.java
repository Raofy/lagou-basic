package com.ryan.stage2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDQLTest {

    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();

        // 1. 查询所有记录
        String search = "select * from jdbc_user WHERE username = '张百万';";
        ResultSet resultSet = statement.executeQuery(search);
        //2.处理结果集
        while(resultSet.next()){
            //通过列名 获取字段信息
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String birthday = resultSet.getString("birthday");
            System.out.println(id+" "+username+" " + password +" " + birthday);
        }

        JDBCUtil.close(connection, statement);
    }
}
