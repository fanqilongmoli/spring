package com.fanqilong.spring.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext2.xml")
public class Test3 {

    @Resource
    OrderDao orderDao;

    @Test
    public void test1() {
        orderDao.save();
        orderDao.find();
        orderDao.update();
        orderDao.delete();
    }
}
