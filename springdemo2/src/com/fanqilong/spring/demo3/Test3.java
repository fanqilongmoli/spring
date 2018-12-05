package com.fanqilong.spring.demo3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring IOC xml和注解混合开发
 */
public class Test3 {

    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) applicationContext.getBean("productService");
        productService.save();
    }
}
