package com.fanqilong.spring.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test1 {

    @Test
    // jdbc 模板的使用类似Dbutils
    public void test1(){
        // 创建链接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbc模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account value (null,?,?)","fanqilong",10000d);


    }
}
