package com.ryan.stage2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtilDMLTest {

    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtil.getConnection();
        Statement statement = connection.createStatement();

        // 1. 插入操作
        String sql = "insert into jdbc_user values(null,'张百万','123','2020/1/1')";
        int resultSet = statement.executeUpdate(sql);
        System.out.println(resultSet);                                 // 1为插入成功

        // 2. 更新操作
        String update = "update jdbc_user set username = 'fuyi' where id = 1";
        System.out.println(statement.executeUpdate(update));            //  1为更新成功

        // 3. 删除操作
        statement.executeUpdate("delete from jdbc_user where id in(3,4)");
        JDBCUtil.close(connection, statement);

    }
}
