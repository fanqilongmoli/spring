package com.fanqilong.mybaits.dao.impl;

import com.fanqilong.mybaits.dao.UserDao;
import com.fanqilong.mybaits.pojo.User;
import com.fanqilong.mybaits.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(Integer id) {

        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        User user = sqlSession.selectOne("user.getUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> getUserByUsername(String username) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        List<User> users = sqlSession.selectList("user.getUserByUsername", "张");
        sqlSession.close();
        return users;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        sqlSession.insert("user.insert",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
