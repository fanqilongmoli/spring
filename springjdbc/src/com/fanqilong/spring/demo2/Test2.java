package com.fanqilong.spring.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class Test2 {
    @Resource
    JdbcTemplate jdbcTemplate;

    /**
     * 保存
     */
    @Test
    public void test1() {
        jdbcTemplate.update("insert into account values (null,?,?)", "fanqilong5", 100d);
    }

    /**
     * 修改
     */
    @Test
    public void update() {
        jdbcTemplate.update("update account set money = ? where id = 1", 1000d);
    }

    /**
     * 查询
     */
    @Test
    public void find() {
        String name = jdbcTemplate.queryForObject("select name from account where id=?", String.class, 1);
        System.out.println(name);
    }

    /**
     * 查询个数
     */
    @Test
    public void count() {
        final Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }

    /**
     * 封装到一个对象中
     */
    @Test
    public void test2() {
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new MyRowMapper(), 2);
        System.out.println(account);
    }

    /**
     * 查询多条记录
     */
    @Test
    public void test3() {
        List<Account> query = jdbcTemplate.query("select * from account", new MyRowMapper());
        for (Account account : query) {
            System.out.println(account);
        }
    }


    class MyRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getDouble("money"));
            return account;
        }
    }
}
