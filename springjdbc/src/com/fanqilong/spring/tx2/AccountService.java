package com.fanqilong.spring.tx2;

/**
 * 转账业务接口
 */
public interface AccountService {
     void transfer(String from, String to, Double money);
}
