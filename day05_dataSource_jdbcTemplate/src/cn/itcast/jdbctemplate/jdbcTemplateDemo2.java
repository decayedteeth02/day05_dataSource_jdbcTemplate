package cn.itcast.jdbctemplate;

import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class jdbcTemplateDemo2 {
    //1.获取JdbcTemplate对象
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    private Emp[] list;

    //Junit单元测试
    @Test
    //修改孙悟空工资为1w
    public void test1(){
        //2.定义sql
        String sql="update emp set salary=10000 where id=1001";
        //3.执行sql
        int update = template.update(sql);
        System.out.println(update);

    }

    @Test
    //2.添加一条记录
    public void test02(){
        String sql="insert into emp(id,ename,dept_id) values(?,?,?)";
        int update = template.update(sql,1015,"郭靖",10);
        System.out.println(update);
    }

    @Test
    //3.删除记录
    public void test03(){
        String sql="delete from emp where id =?";
        int update = template.update(sql,1015);
        System.out.println(update);
    }

    @Test
    //4.查询id为1的记录
    public void test04(){
        String sql="select * from emp where id =?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    @Test
    //5.查询所有的记录，其封装为list
    public void test05(){
        String sql="select * from emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    //查询所有记录，将其封装为EMP对象的list集合
    public void test06(){
        String sql="select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    //查询总记录
    public void test07(){
        String sql="select count(id) from emp";
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println(aLong);
    }

}
