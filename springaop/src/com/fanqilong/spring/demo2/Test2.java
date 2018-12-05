package com.fanqilong.spring.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * AOP 入门
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class Test2 {

    @Resource(name = "productDao")
    private ProductDao productDao;

    /**
     * 前置通知：在目标方法执行之前进行操作
     *         - 获取切入点的信息
     *
     * 后置通知：在目标方法执行之后进行操作
     *         -获取方法的返回值
     *
     * 环绕通知：在目标方法执行之前和之后进行操作
     *         -可以阻止目标方法的执行
     *
     * 异常抛出通知：在程序出现异常的时候，进行操作
     *
     * 最终通知：无论代码是否有异常，总是会执行
     *
     * 引介通知：（了解）
     *
     *
     * spring切入点表达式写法 （基于execution的函数完成的）
     *  【访问修饰符】 方法返回值 包名.类名.方法名(参数)
     *   public void com.fanqilong.spring.demo2.ProductDao.save(..)
     *
     *    * com.fanqilong.spring.demo2.ProductDao.save(..)
     *
     *    * *.*.*.*Dao.save(..)
     *
     *    * com.fanqilong.spring.demo2.ProductDao+.save(..)    // + 号表示当前的类及其子类
     *
     *    * com.fanqilong.spring..*.*(..)    // com.fanqilong.spring 子包下面的所有类所有方法
     *
     */

    @Test
    public void test1() {
        productDao.update();
        productDao.save();
        productDao.find();
        productDao.delete();
    }
}
