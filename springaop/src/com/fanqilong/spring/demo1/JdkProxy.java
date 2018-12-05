package com.fanqilong.spring.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk动态代理对UserDao 产生代理
 */
public class JdkProxy implements InvocationHandler {
    private UserDao userDao;

    public JdkProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 产生UserDao代理方法
     *
     * @return
     */
    public UserDao createProxy() {

        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader()
                , userDao.getClass().getInterfaces(), this);

        return userDaoProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判断方法名是否是save
        if ("save".equals(method.getName())) {
            //增强
            System.out.println("权限校验===========");
            return method.invoke(userDao, args);

        }

        return method.invoke(userDao, args);
    }
}
