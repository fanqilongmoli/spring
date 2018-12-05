package com.fanqilong.spring.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier(value = "userDao")
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void save() {
        System.out.println("userService执行。。。。。。");
        userDao.save();
    }
}
