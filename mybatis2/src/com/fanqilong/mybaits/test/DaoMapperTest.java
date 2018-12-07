package com.fanqilong.mybaits.test;

import com.fanqilong.mybaits.mapper.UserMapper;
import com.fanqilong.mybaits.pojo.User;
import com.fanqilong.mybaits.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class DaoMapperTest {

    @Test
    public void testGetUserById(){
        final SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        // 获取接口的代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        final User userById = userMapper.getUserById(10);
        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void testGetUserByUsername(){
        final SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();

        // 获取接口的代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.getUserByUsername("张").forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        final SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();

        // 获取接口的代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("fanqilong");
        user.setAddress("address");
        user.setBirthday(new Date());
        user.setSex("男");
        userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
