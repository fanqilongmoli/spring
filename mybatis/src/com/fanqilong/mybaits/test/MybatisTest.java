package com.fanqilong.mybaits.test;

import com.fanqilong.mybaits.pojo.User;
import com.fanqilong.mybaits.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {


    @Test
    public void test1() throws IOException {
        //创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        //创建核心配置文件的输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
        //通过输入流创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = ssfb.build(resourceAsStream);
        //创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 参数一是 sql id   参数二是：入参
        User user = sqlSession.selectOne("user.getUserById", 10);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void testGetUserByUsername() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("user.getUserByUsername", "张");
        for (User user : users) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("fanqilong2");
        user.setSex("1");
        user.setAddress("address");
        user.setBirthday(new Date());
        sqlSession.insert("user.insertUser", user);

        System.out.println(user);
        //提交事物
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateUser(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("user.getUserById", 29);
        user.setUsername("fanqilong666");
        sqlSession.update("user.updateUser",user);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("user.deleteUser",26);
        sqlSession.commit();
        sqlSession.close();
    }
}
