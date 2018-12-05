package com.fanqilong.spring.tx2;

/**
 * 转账的业务实现
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @param from  转出的账号
     * @param to    转入的账号
     * @param money 金额
     * spring 声明式事务管理
     */
    @Override
    public void transfer(String from, String to, Double money) {

        accountDao.outMoney(from, money);
        int d = 1 / 0;
        accountDao.inMoney(to, money);

    }
}
