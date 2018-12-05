package com.fanqilong.spring.tx3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config-tx3.xml")
public class Test3 {

    /**
     * spring的事物管理器： 二声明式事物管理（通过配置实现）----AOP
     *
     * 声明式事务管理   注解方式声明事物管理器
     */


    @Resource
    AccountService accountService;

    @Test
    public void test1(){

        accountService.transfer("fanqilong","gongli",100d);

    }
}
