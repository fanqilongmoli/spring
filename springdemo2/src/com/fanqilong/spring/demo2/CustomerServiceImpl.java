package com.fanqilong.spring.demo2;

import com.fanqilong.spring.demo1.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @PostConstruct  //相当于 init-method
    public void init(){
        System.out.println("CustomerService 初始化完成。。。。。");
    }

    @Override
    public void save() {
        System.out.println(userDao);
    }

    @PreDestroy // 相当于 destroy-method
    public void destroy(){
        System.out.println("CustomerService 准备销毁。。。。。");
    }
}
