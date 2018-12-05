package com.fanqilong.spring.demo2;

public class CustomerDaoImpl implements CustomerDao {

    public void setup(){
        System.out.println("执行了setUp");
    }

    @Override
    public void save() {
        System.out.println("CustomerDaoImpl........");
    }

    public void destory(){
        System.out.println("执行了destory");
    }
}
