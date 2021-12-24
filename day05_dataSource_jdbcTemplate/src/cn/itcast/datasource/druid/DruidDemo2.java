package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.定义sql
            String sql ="insert into account values(null,?,?)";
            //3.获取pstmt对象
            preparedStatement = connection.prepareStatement(sql);
            //4.给问好赋值
            preparedStatement.setString(1,"王五");
            preparedStatement.setDouble(2,3000);
            //5.执行sql
            int i = preparedStatement.executeUpdate();
            System.out.println(i);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement,connection);
        }


    }

}
