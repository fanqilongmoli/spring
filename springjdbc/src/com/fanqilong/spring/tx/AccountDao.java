package com.fanqilong.spring.tx;

/**
 * 转账的Dao的接口
 */
public interface AccountDao {
    void outMoney(String from, Double money);
    void inMoney(String to, Double money);
}
