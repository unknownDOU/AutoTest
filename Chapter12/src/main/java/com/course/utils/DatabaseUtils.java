package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/03
 */
public class DatabaseUtils {

    public static SqlSession getSqlSession() throws IOException {
        //获取配置资源文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //sqlSession就是能执行配置文件中的sql语句
        SqlSession sqlSession = factory.openSession();

        return sqlSession;
    }
}
