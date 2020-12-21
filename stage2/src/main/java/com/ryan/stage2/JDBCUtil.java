package com.ryan.stage2;

import java.sql.*;

public class JDBCUtil {

    // 1. 定义常量字符串
    private final static String URL = "jdbc:mysql://175.24.16.47:3306/JDBC?characterEncoding=UTF-8";
    private final static String DRIVERNAME = "com.mysql.jdbc.Driver";
    private final static String USER = "root";
    private final static String PASSWORD = "123456@Fuyi.com";

    // 2. 定义静态代码块
    static {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 3. 获取连接的静态方法
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 4. 关闭资源方法
    public static void close(Connection connection, Statement statement) {
        if (null != connection && null != statement) {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
                close(connection, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
