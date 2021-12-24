package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.获取datasource 使用默认配置
//        DataSource ds=new ComboPooledDataSource();
        //1.1 获取datasource,使用指定名称的配置
        DataSource ds=new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i=1;i<=10;i++){
            Connection connection=ds.getConnection();
            System.out.println(i+":"+connection);

        }

    }
}
