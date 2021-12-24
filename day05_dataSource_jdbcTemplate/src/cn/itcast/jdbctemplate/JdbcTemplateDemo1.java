package cn.itcast.jdbctemplate;


import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql="update emp set salary =10000 where id =?";
        int count = jdbcTemplate.update(sql, 1);
        System.out.println(count);
    }

}
