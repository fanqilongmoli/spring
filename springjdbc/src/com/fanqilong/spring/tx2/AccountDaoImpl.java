package com.fanqilong.spring.tx2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 转账dao实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    @Override
    public void outMoney(String from, Double money) {
        this.getJdbcTemplate().update("update account set money = money - ? where name = ?", money, from);
    }

    @Override
    public void inMoney(String to, Double money) {
        this.getJdbcTemplate().update("update account set money = money + ? where name = ?", money, to);
    }
}
