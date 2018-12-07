package com.fanqilong.mybaits.mapper;

import com.fanqilong.mybaits.pojo.User;

import java.util.List;

/**
 * 2.动态代理dao的开发规则
 *    1> namespace必须是接口全路径名
 *    2>接口的方法必须与映射文件的sql id一致
 *    3>接口参数类型必须与映射文件的parameterType类型一致
 *    4>接口返回值类型必须与映射文件resultType类型一致
 */
public interface UserMapper {

    User getUserById(Integer id);

    List<User> getUserByUsername (String username);

    void insertUser(User user);
}
