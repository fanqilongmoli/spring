package com.fanqilong.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository(value = "userDao") //等价与在xml中配置<bean id="userDao" class="com.fanqilong.spring.demo1.UserDaoImpl"/>
public class UserDaoImpl implements UserDao {

    @Value("sdasdasd")
    private String name;


    @Override
    public void save() {
        System.out.println("UserDaoImpl ......"+ name);
    }
}
