package com.fanqilong.spring.demo2;

import com.fanqilong.spring.demo1.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    @Test
    public void test() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        CustomerDao customerDao1 = (CustomerDao) applicationContext.getBean("customer");
        customerDao1.save();
        CustomerDao customerDao2 = (CustomerDao) applicationContext.getBean("customer");


        System.out.println(customerDao1);
        System.out.println(customerDao2);
        System.out.println(customerDao1 == customerDao2);

    }
}
