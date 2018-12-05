package com.fanqilong.spring.tx3;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

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
