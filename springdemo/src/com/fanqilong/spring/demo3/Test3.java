package com.fanqilong.spring.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 属性注入的方式
 */
public class Test3 {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        Car2 car2 = (Car2) applicationContext.getBean("car2");
        System.out.println(car2);

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
