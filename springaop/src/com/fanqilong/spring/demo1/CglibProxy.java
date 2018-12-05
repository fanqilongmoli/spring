package com.fanqilong.spring.demo1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private CustomerDao customerDao;

    public CglibProxy(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 使用 Cglib产生代理方法
     *
     * @return
     */
    public CustomerDao createProxy() {
        // 1.创建Cglib核心对象
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(customerDao.getClass());
        // 3.设置回调：（类似一个InvocationHandler对象）
        enhancer.setCallback(this);
        // 4.创建代理对象
        CustomerDao proxy = (CustomerDao) enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("save".equals(method.getName())){
            //增强
            System.out.println("权限校验===========");
            return methodProxy.invokeSuper(proxy,objects);
        }
        return methodProxy.invokeSuper(proxy,objects);
    }
}
