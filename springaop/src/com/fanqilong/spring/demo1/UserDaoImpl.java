package com.fanqilong.spring.demo1;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl 执行 save");
    }

    @Override
    public void update() {
        System.out.println("UserDaoImpl 执行 update");
    }

    @Override
    public void delete() {
        System.out.println("UserDaoImpl 执行 delete");
    }

    @Override
    public void find() {
        System.out.println("UserDaoImpl 执行 find");
    }
}
