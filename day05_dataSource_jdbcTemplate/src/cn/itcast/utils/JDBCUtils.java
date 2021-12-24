package cn.itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    //1.定义成员变量
    private static DataSource dataSource;
    static {
        //1.加载配置文件

        try {
            Properties properties=new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取dataSource
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(ResultSet rs, Statement statement, Connection connection){
        if (statement !=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection !=null){
            try {
                connection.close();//归还连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    public static void close(Statement statement, Connection connection){
        /*if (statement !=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection !=null){
            try {
                connection.close();//归还连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
        close(null,statement,connection);
    }

    //获取连接池方法
    public static DataSource getDataSource(){
        return dataSource;

    }


}
