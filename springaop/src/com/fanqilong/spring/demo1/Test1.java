package com.fanqilong.spring.demo1;

import org.junit.Test;

public class Test1 {
    /**
     * JDK 动态代理只能对实现了接口的类
     *
     * Cglib 代理不需要类实现接口
     * AOP 开发的相关术语
     * Joinpoint（接入点）：所谓链接点就是指那些被拦截到的点，在spring中，这些点指的是方法，因为spring只支持方法类型的接入点
     * Pointcut（切入点）：所谓的切入点指的是我们要多哪些Joinpoint进行拦截定义
     * Advice（通知/增强）：所谓通知就是拦截到Joinpoint之后要做的事情就是通知，通知分为前置通知，后置通知，异常通知，最终通知，环绕通知（切面要完成功能）
     * Introduction（引介）：引介是一种特殊的通知在不修改代码的前提下，Introduction可以再运行期动态添加一些方法或Field
     * Target（目标对象）：代理目标对象
     * weaving（织入）：是指把增强（Advice）应用到目标对象（Target）来创建新的代理对象的过程
     * spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入
     * Proxy（代理）：一个类被AOP织入增强后，就产生一个结果代理类
     * Aspect（切面）：是切入点和通知（介入）的结合
     */

    /**
     * JDK 动态代理
     */
    @Test
    public void test1() {

        UserDao userDao = new UserDaoImpl();
        //创建代理
        UserDao proxy = new JdkProxy(userDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.find();
        proxy.delete();
    }

    @Test
    public void test2() {

        CustomerDao customerDao = new CustomerDao();
        //创建代理
        CustomerDao proxy = new CglibProxy(customerDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.find();
        proxy.delete();
    }
}
