package com.fanqilong.mybaits.dao;

import com.fanqilong.mybaits.pojo.User;

import java.util.List;

/**
 * 1.原始的dao方法
 */
public interface UserDao {

    User getUserById(Integer id);

    List<User> getUserByUsername (String username);

    void insertUser(User user);
}
