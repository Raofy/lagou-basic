package com.ryan.stage2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransaction {

    //JDBC 操作事务
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //1. 获取连接
            con = JDBCUtil.getConnection();
            //2. 开启事务
            con.setAutoCommit(false);
            //3. 获取到 PreparedStatement 执行两次更新操作
            //3.1 tom 账户 -500
            ps = con.prepareStatement("update account set money = money - ? where name = ? ");
            ps.setDouble(1,500.0);
            ps.setString(2,"tom");
            ps.executeUpdate();
            //模拟tom转账后 出现异常
            System.out.println(1 / 0);
            //3.2 jack 账户 +500
            ps = con.prepareStatement("update account set money = money + ? where name = ? ");
            ps.setDouble(1,500.0);
            ps.setString(2,"jack");
            ps.executeUpdate();
            //4. 正常情况下提交事务
            con.commit();
            System.out.println("转账成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //5. 出现异常回滚事务
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            //6. 最后关闭资源
            JDBCUtil.close(con,ps);
        }
    }
}
