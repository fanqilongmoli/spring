package com.fanqilong.mybaits.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {

        InputStream resourceAsStream = null;
        try {
            //创建SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
            //创建核心配置文件的输入流
            resourceAsStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
            //通过输入流创建SqlSessionFactory对象
            sqlSessionFactory = ssfb.build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
